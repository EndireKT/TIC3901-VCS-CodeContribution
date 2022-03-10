package projectFiles;

import commandPrompt.CommandPrompt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ProjectInfo {

    private String currentLocalPath;
    private String remoteRepoGitURL;
    ArrayList<FileInfo> javaFilesFromCommit;
    private ArrayList<String> commitList;
    private ArrayList<String> committerList;
    ArrayList<FileInfo> latestFilesCheckedAndUpdated;
    private String commitChecked;
    private String mainContributor;

    public ProjectInfo(String localPath){
        // Set path info
        currentLocalPath = localPath;
    }

    public ProjectInfo getProjectInfo() {

        String pathCode = getLocalPathInCode(currentLocalPath);
        remoteRepoGitURL = getGitRemoteProjectURL(pathCode);

        if (this.hasRemoteGitRepo() == false) {
            System.out.println("Can't check contribution, project does not exist on Github.");
            return null;
        }

        this.setCommitDetails(pathCode);

        if (this.hasCommitDetails() == false) {
            System.out.println("Unable to check contribution due to missing Commit details");
            return null;
        }
        if (this.hasValidCommitDetails() == false) {
            System.out.println("Commit details do not tally.");
            return null;
        }

        this.checkThroughCommits(pathCode);
        this.updateProjectMainContributor();

        return this;
    }


    // Takes the local path and parses it
    // into a string where path can be recognized by the code
    // e.g. return String will be " C:\\user1\\folder\\file "
    private static String getLocalPathInCode(String localPath) {
        String[] pathParts = localPath.split("\\\\");
        String pathCode = pathParts[0];
        for (int i = 1; i < pathParts.length; i++) {
            pathCode = pathCode + "\\\\" + pathParts[i];
        }
        return pathCode;
    }

    // Get the Remote Repo URL/Path of the project
    private String getGitRemoteProjectURL(String pathCode) {
        ProcessBuilder pBuilder = new ProcessBuilder();
        String commandInput = "cd " + pathCode + " && git config --get remote.origin.url";
        pBuilder.command("cmd.exe", "/c", commandInput);
        try {
            Process process = pBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String remoteURL = reader.readLine();
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            return remoteURL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String> getCommitList(String pathCode) {
        try {
            Process process = CommandPrompt.getProjectCommitHash(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;
            ArrayList<String> commits = null;
            while (hasLine) {
                String commitHash = reader.readLine();
                if (commitHash == null) {
                    hasLine = false;
                    continue;
                }
                commits.add(commitHash);
            }
            return commits;
        } catch (IOException e) {
            System.out.println("Unable to get commit hashes");
            return null;
        }
    }

    private ArrayList<String> getCommitterList(String pathCode) {
        try {
            Process process = CommandPrompt.getCommitterName(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;
            ArrayList<String> committers = null;
            while (hasLine) {
                String committerName = reader.readLine();
                if (committerName == null) {
                    hasLine = false;
                    continue;
                }
                committers.add(committerName);
            }
            return committers;
        } catch (IOException e) {
            System.out.println("Unable to get committers");
            return null;
        }
    }

    private void setCommitDetails(String pathCode){
        commitList = getCommitList(pathCode);
        committerList = getCommitterList(pathCode);
    }

    private boolean hasCommitDetails() {
        if (commitList == null || committerList == null) {
            return false;
        }
        return true;
    }

    private boolean hasValidCommitDetails() {
        if (commitList.size() != committerList.size()) {
            return false;
        }
        return true;
    }

    // Check whether Project has a Git remote repo
    private boolean hasRemoteGitRepo() {
        if (remoteRepoGitURL == null) {
            return false;
        }
        return true;
    }

    // Calls fileIdentifier to get all the fileInfo of the Java files inside the Project
    private void addJavaFilesFromCommit(String pathCode, String commitHash,
                                        String commitContributor) {
        javaFilesFromCommit = FileIdentifier.getJavaFilesFromPath(pathCode,
                commitHash, commitContributor);
    }


    private void checkThroughCommits(String pathCode) {
        int size = commitList.size();
        for (int i = size-1; i >= 0; i-- ) {
            String currentCommit = commitList.get(i);
            String commitContributor = committerList.get(i);
            CommandPrompt.checkoutCommit(pathCode, currentCommit);
            this.addJavaFilesFromCommit(pathCode, currentCommit, commitContributor);
            updateLatestFileChecked(currentCommit, commitContributor);
        }
    }

    private void updateLatestFileChecked(String commit, String committer) {
        if (latestFilesCheckedAndUpdated != null) {
            updateCheckedFiles();
        } else if (javaFilesFromCommit == null) {
            mainContributor = committer;
        }
        latestFilesCheckedAndUpdated = javaFilesFromCommit;
        commitChecked = commit;
    }

    private void updateCheckedFiles() {
        // Check for files with same name in "javaFilesFromCommit" and "latestFilesCheckedAndUpdated"
        // If there are files with the same name, call the function
        // "checkContributionBetweenTwoFileVersions" from ContributionChecker
        // "fileFromOlderCommit" will be from the "latestFilesCheckedAndUpdated" ArrayList
        // "fileFromNewerCommit" will be from the "javaFilesFromCommit"
        // fileFromOlderCommit.getFileName() == fileFromNewerCommit.getFileName()
    }

    private void updateProjectMainContributor() {
        if (latestFilesCheckedAndUpdated == null) {
            return;
        }
        // Check through the mainContributors of the files in "latestFilesCheckedAndUpdated"
        // The name of the mainContributor that's repeated the most will be the
        // mainContributor for this project
    }

    public void printContributorsInfo() {
        System.out.println("The main contributor for the project is " + mainContributor);
        for (int i = 0; i < latestFilesCheckedAndUpdated.size(); i++){
            FileInfo currentFile = latestFilesCheckedAndUpdated.get(i);
            String fileName = currentFile.getFileName();
            String fileContributor = currentFile.getMainContributor();
            System.out.println("The main contributor for the file '" + fileName +
                    "' is " + fileContributor);
        }
    }

}
