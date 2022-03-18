package projectFiles;

import java.io.File;
import java.util.ArrayList;

import commandprompt.CmdPrompt;
import contributionChecker.ContributionChecker;
import storage.ProgressReader;
import storage.ProgressRecorder;

public class ProjectInfo {
    private ContributionChecker contributionChecker;
    private String currentLocalPath;
    private String pathCode;
    private String remoteRepoGitUrl;
    private ArrayList<String> commitList;
    private ArrayList<String> committerList;
    private boolean hasContributionCheckHisotry;
    private ArrayList<FileInfo> javaFromCommit_CurrentCommit;
    private ArrayList<FileInfo> javaFromCommit_PreviousCommit;
    private File file_CurrentCommit;
    private File file_PreviousCommit;
    private ArrayList<String> projectContributor;

    public ProjectInfo(String localPath) {
        currentLocalPath = localPath;
        contributionChecker = new ContributionChecker();
        javaFromCommit_CurrentCommit = new ArrayList<>();
        javaFromCommit_PreviousCommit = new ArrayList<>();
    }

    /**
     * Contains the main Logic of the project
     * This method do these in sequence
     * 1. Obtain pathCode
     * 2. Obtain remote repo git url
     * 3. Validate the repo git url
     * 4. Obtain a list of commit hash, which acts as an ID of the commit
     * 5. Obtain a list of committer, which represents the name of the person who commit
     * 6. Validate the two lists to ensure they are fit for comparison
     * 7. Initiate progress read, it reads the existing progress text file.
     *      This file acts as a history for file evaluation.
     * 8. Modify the commit and committer list based on the progress text file.
     *      This step avoids repeating evaluation of commit that has been evaluated before.
     * 9. Initiate the contribution check for each remaining commit,
     *      output is recorded in javaFromCommit_CurrentCommit
     * 10. Initiate the evaluation of main project contributor using javaFromCommit_CurrentCommit,
     *      output is recorded in projectContributor
     * 11. Record the output to a text file
     *
     * @return ProjectInfo
     */
    public ProjectInfo getProjectInfo() {

        pathCode = PathEncoder.getLocalPathInCode(currentLocalPath);
        remoteRepoGitUrl = PathEncoder.getGitRemoteProjectUrl(pathCode);

        if (!RepoValidator.isRemoteGitRepoExist(remoteRepoGitUrl)) {
            return null;
        }

        commitList = CListGenerator.getCommitList(pathCode);
        committerList = CListGenerator.getCommitterList(pathCode);

        if (!RepoValidator.isCommitExist(commitList)
                || !RepoValidator.isCommitterExist(committerList)
                || !RepoValidator.isTwoListSizeEqual(commitList, committerList)) {
            return null;
        }

        initiateProgressRead();
        if (hasContributionCheckHisotry) {
            modifyCommitAndCommitterList();
        }

        initiateContributionCheckForEachCommit();

        // todo delete these later
        for (FileInfo fileInfo : javaFromCommit_CurrentCommit) {
            System.out.println(fileInfo.getFilePath());
            System.out.println(fileInfo.getMainContributor());
            System.out.println(fileInfo.getCommitID() + "\n");
        }
        System.out.println("Done");

        projectContributor = contributionChecker.compareFileMainContributor(javaFromCommit_CurrentCommit);
        new ProgressRecorder(javaFromCommit_CurrentCommit).record();

        return this;
    }

    private void initiateProgressRead() {
        ArrayList<FileInfo> fileInfoHistory = ProgressReader.read(currentLocalPath);
        if (!fileInfoHistory.isEmpty()) {
            javaFromCommit_PreviousCommit = fileInfoHistory;
            hasContributionCheckHisotry = true;
        } else {
            hasContributionCheckHisotry = false;
        }
    }

    private void modifyCommitAndCommitterList() {
        String commitHistory = javaFromCommit_PreviousCommit.get(0).getCommitID();
        // todo CONTINUE FROM HERE
        int i;
        for (i = 0; i < commitList.size(); i++) {
            if (commitHistory.equals(commitList.get(i))) {
                break;
            }
        }

        if (i == commitList.size()) {
            return;
        } else {
            // todo
        }
    }

    private void initiateContributionCheckForEachCommit() {
        int size = commitList.size();
        for (int i = size - 1; i >= 0; i--) {
            String currentCommit = commitList.get(i);
            String committer = committerList.get(i);

            CmdPrompt.checkoutCommit(pathCode, currentCommit);
            javaFromCommit_PreviousCommit = javaFromCommit_CurrentCommit;
            identifyJavaFilesFromCommit(currentCommit, committer);
            initiateContributionCheckForEachFileInfo(i, size);
        }
    }

    /**
     * calls FileIdentifier to identify all Java files in a folder
     * and record a list of FileInfo for all captured Java file into javaFilesFromCommit
     *
     * @param commitHash String that represents the Hash of the commit
     * @param committer  String that represents the ID of the committer
     */
    private void identifyJavaFilesFromCommit(String commitHash, String committer) {
        try {
            javaFromCommit_CurrentCommit = FileIdentifier.getJavaFilesFromPath(pathCode, commitHash, committer);
        } catch (Exception e) {
            System.out.println("No Java files at the folder");
            e.printStackTrace();
        }
    }

    private void initiateContributionCheckForEachFileInfo(int i, int size) {
        if (i != size - 1) {
            for (int j = 0; j < javaFromCommit_CurrentCommit.size(); j++) {
                FileInfo fileInfo_CurrentCommit = javaFromCommit_CurrentCommit.get(j);
                FileInfo fileInfo_PreviousCommit = javaFromCommit_PreviousCommit.get(j);

                file_CurrentCommit = new File(fileInfo_CurrentCommit.getFilePath());
                file_PreviousCommit = new File(fileInfo_PreviousCommit.getFilePath());

                String fileContent_CurrentCommit = ProjectFileReader.readFile(file_CurrentCommit);
                String fileContent_PreviousCommit = ProjectFileReader.readFile(file_PreviousCommit);

                if (contributionChecker.compareContribution(fileContent_CurrentCommit, fileContent_PreviousCommit)) {
                    String mainContributor = fileInfo_CurrentCommit.getMainContributor();
                    javaFromCommit_CurrentCommit.get(j).setMainContributor(mainContributor);
                }
            }
        }
    }
}
