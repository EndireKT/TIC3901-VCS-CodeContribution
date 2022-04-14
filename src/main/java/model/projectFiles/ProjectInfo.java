package model.projectFiles;

import java.util.ArrayList;
import java.util.Set;

import model.commandprompt.CmdPrompt;
import model.contributionChecker.ContributionChecker;
import model.fileInfo.FileIdentifier;
import model.fileInfo.FileInfo;
import model.storage.ProgressReader;
import model.storage.ProgressRecorder;

public class ProjectInfo {
    private ContributionChecker contributionChecker;
    private String directoryPath;
    private String pathCode;
    private ArrayList<String> commitList;
    private ArrayList<String> authorList;
    private String userStartCommit;

    private boolean hasUpdatedContributionCheckHisotry;
    private String commitInProgress;
    private ArrayList<FileInfo> fileInfos_CurrentCommit;
    private ArrayList<FileInfo> fileInfos_PreviousCommit;
    private Set<String> contributorFrequency;
    private ArrayList<String> projectMainContributors;

    public ProjectInfo(String directoryPath,
                       String pathCode,
                       ArrayList<String> commitList,
                       ArrayList<String> authorList,
                       String userStartCommit) {
        this.directoryPath = directoryPath;
        this.pathCode = pathCode;
        this.commitList = commitList;
        this.authorList = authorList;
        this.userStartCommit = userStartCommit;

        contributionChecker = new ContributionChecker();
        fileInfos_CurrentCommit = new ArrayList<>();
        fileInfos_PreviousCommit = new ArrayList<>();
    }

    /**
     * Contains the main Logic of the contribution check
     * This method do these in sequence
     * 1. Initiate progress read, it reads the existing progress text file.
     * -----This file acts as a history for file evaluation.
     * 2. Modify the commit and author list based on the progress text file.
     * -----This step avoids repeating evaluation of commit that has been evaluated before.
     * 3. Initiate the contribution check for each remaining commit,
     * -----output is recorded in javaFromCommit_CurrentCommit
     * 4. Initiate the evaluation of main project contributor using javaFromCommit_CurrentCommit,
     * -----output is recorded in projectContributor
     * 5. Record the output to a text file
     *
     * @return ProjectInfo
     */
    public ProjectInfo getProjectInfo() {

        modifyCommitAndAuthorList(userStartCommit);

        initiateProgressRead();
        if (hasUpdatedContributionCheckHisotry) {
            modifyCommitAndAuthorList(commitInProgress);
        }

        initiateContributionCheckForEachCommit();

        contributionChecker.evaluateFileInfos(fileInfos_CurrentCommit);
        contributorFrequency = contributionChecker.getContributorFrequency();
        projectMainContributors = contributionChecker.getProjectMainContributors();


        new ProgressRecorder(fileInfos_CurrentCommit).record();

        return this;
    }

    public ArrayList<FileInfo> getFileInfos_CurrentCommit() {
        return fileInfos_CurrentCommit;
    }

    public Set<String> getContributorFrequency() {
        return contributorFrequency;
    }

    public ArrayList<String> getProjectMainContributors() {
        return projectMainContributors;
    }

    private void initiateProgressRead() {
        ArrayList<FileInfo> fileInfoHistory = ProgressReader.read(directoryPath);
        hasUpdatedContributionCheckHisotry = false;
        if (!fileInfoHistory.isEmpty()) {
            commitInProgress = fileInfoHistory.get(0).getCommitID();
            if (isFileProgressWithinCommitList(commitInProgress)){
                fileInfos_PreviousCommit = fileInfoHistory;
                hasUpdatedContributionCheckHisotry = true;
            }
        }
    }

    private void modifyCommitAndAuthorList(String userStartCommit) {
        ArrayList<String> tempCommitList = new ArrayList<>();
        ArrayList<String> tempAuthorList = new ArrayList<>();

        for (int i = 0; i < commitList.size(); i++) {
            tempCommitList.add(commitList.get(i));
            tempAuthorList.add(authorList.get(i));
            if (commitList.get(i).equals(userStartCommit)){
                break;
            }
        }
        commitList = tempCommitList;
        authorList = tempAuthorList;
    }

    private Boolean isFileProgressWithinCommitList(String commitInProgress){
        for (String commit : commitList){
            if (commit.equals(commitInProgress)){
                return true;
            }
        }
        return false;
    }

    /**
     * Initialize the contribution check for each commit
     * Perform these steps in sequence:
     * 0. If there is a previous record of FileInfo, save it in fileInfos_CurrentCommit
     * 1. Obtain commit ID and author name from the back of the list (from oldest to most recent)
     * 2. Keep a copy of the FileInfos in FileInfos_PreviousCommit
     * -----FileInfos_PreviousCommit stores the FileInfos of previous commit
     * 3. Git checkout using the commit ID
     * 4. Identify all current java files in the current commit
     * 5. Calls for contribution check for each FileInfo
     */
    private void initiateContributionCheckForEachCommit() {
        int size = commitList.size();
        if (!fileInfos_PreviousCommit.isEmpty()) {
            fileInfos_CurrentCommit = fileInfos_PreviousCommit;
        }
        for (int commitListIterator = size - 1; commitListIterator >= 0; commitListIterator--) {
            String currentCommit = commitList.get(commitListIterator);
            String author = authorList.get(commitListIterator);

            fileInfos_PreviousCommit = fileInfos_CurrentCommit;
            initiateGitCheckOutCommit(currentCommit);
            identifyJavaFilesFromCurrentCommit(currentCommit, author);
            initiateContributionCheckForEachFileInfo(commitListIterator, size);
        }
    }

    /**
     * Initialize the git commit checkout
     *
     * @param currentCommit String representing the commit ID
     */
    private void initiateGitCheckOutCommit(String currentCommit) {
        try {
            CmdPrompt.checkoutCommit(pathCode, currentCommit);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * calls FileIdentifier to identify all Java files in a folder
     * and record a list of FileInfo for all captured Java file into FileInfos_CurrentCommit
     *
     * @param commitHash String that represents the Hash of the commit
     * @param author     String that represents the ID of the author
     */
    private void identifyJavaFilesFromCurrentCommit(String commitHash, String author) {
        try {
            fileInfos_CurrentCommit = FileIdentifier.getJavaFilesFromPath(pathCode, commitHash, author);
        } catch (Exception e) {
            System.out.println("No Java files at the directory");
            e.printStackTrace();
        }
    }

    /**
     * Initiate the contribution check for each file in a folder
     * <p>
     * This method do these in sequence:
     * 1. Loop through fileInfos_CurrentCommit
     * 2. Obtain FileInfo from fileInfos_CurrentCommit
     * 3. for each file in fileInfo_CurrentCommit, obtain fileName
     * 4. search through fileInfo_PreviousCommit for the same fileName
     * 5. if same fileName is found, obtain the String from both file
     * 6. Call for contribution check using the two strings
     * ---- fileContent_CurrentCommit >> Content of the file in current commit
     * ---- fileContent_PreviousCommit >> Content of the file in previous commit
     * 7. Modify main contributor of the file_CurrentCommit based on return of contribution check
     * ---- if return true, do nothing.
     * --------- main contributor in fileInfo of fileInfos_CurrentCommit is the contributor.
     * ---- if return false, change main contributor of javaFromCommit_CurrentCommit
     * --------- main contributor in fileInfo of fileInfos_CurrentCommit is the contributor
     *
     * @param commitListIterator integer iterator
     * @param size               integer representing the size of the commit list
     */
    private void initiateContributionCheckForEachFileInfo(int commitListIterator, int size) {

        if (commitListIterator == size - 1 && fileInfos_PreviousCommit.isEmpty()) {
            return;
        }

        for (int iterator_current = 0; iterator_current < fileInfos_CurrentCommit.size(); iterator_current++) {
            FileInfo fileInfo_CurrentCommit = fileInfos_CurrentCommit.get(iterator_current);
            String fileName_currentCommit = fileInfo_CurrentCommit.getFileName();

            int iterator_previous;
            for (iterator_previous = 0; iterator_previous < fileInfos_PreviousCommit.size(); iterator_previous++) {
                String fileName_previousCommit = fileInfos_PreviousCommit.get(iterator_previous).getFileName();
                if (fileName_previousCommit.equals(fileName_currentCommit)) {

                    FileInfo fileInfo_PreviousCommit = fileInfos_PreviousCommit.get(iterator_previous);

                    String fileContent_CurrentCommit = fileInfo_CurrentCommit.getFileContent();
                    String fileContent_PreviousCommit = fileInfo_PreviousCommit.getFileContent();

                    if (!contributionChecker.compareContribution(fileContent_PreviousCommit, fileContent_CurrentCommit)) {
                        String previousContributor = fileInfo_PreviousCommit.getMainContributor();
                        fileInfos_CurrentCommit.get((iterator_current)).setMainContributor(previousContributor);
                    }
                    break;
                }
            }
        }
    }
}
