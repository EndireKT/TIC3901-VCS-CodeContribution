package projectFiles;

import cmd.CommandPrompt;
import contributionChecker.ContributionChecker;
import ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProjectInfo {
    /*
    String currentLocalPath;
    String remoteRepoGitURL;
    // ArrayList<FolderInfo> projectFolders;
    ArrayList<FileInfo> javaFiles;
    private Map<String, User> projectContributors;
    User mostLineContributor;
    User mostCharContributor;

    // todo some private variables
    //private ContributionChecker contributionChecker;

    public ProjectInfo(){

        // set path info
        currentLocalPath = Ui.getProjectPath();
        String pathCode = getLocalPathInCode();
        remoteRepoGitURL = CommandPrompt.getGitRemoteProjectURL(pathCode);

        // get java files using path
        javaFiles = FileIdentifier.getJavaFilesFromPath(pathCode);

        // update projectContributors, mostLineContributor & mostCharContributor
        // 1. Loop through each java file and calls ContributionChecker for each file
        // 2. When each file get updated by ContributionChecker,
        // this Project File gets updated as well
        updateProjectContributions();
    }

    public String getLocalPathInCode() {
        String[] pathParts = currentLocalPath.split("\\\\");
        String pathCode = pathParts[0];
        for (int i = 1; i < pathParts.length; i++) {
            pathCode = pathCode + "\\\\" + pathParts[i];
        }
        return pathCode;
    }

    public void updateProjectContributions() {
        projectContributors = new HashMap<>();
        for (int i = 0; i < javaFiles.size(); i++) {
            FileInfo file = javaFiles.get(i);
            file.updateFileContributions();
            Map<String, User> fileUsers = file.getFileContributors();
            addContributionsFromFile(fileUsers);
        }
    }

    private void addContributionsFromFile(Map<String, User> fileContributors) {
        for (Map.Entry<String, User> entry : fileContributors.entrySet()) {
            String fileContributor = entry.getKey();
            User fileContributorInfo = entry.getValue();
            boolean isNewUser = !projectContributors.containsKey(fileContributor);
            if (isNewUser) {
                projectContributors.put(fileContributor, fileContributorInfo);
            } else {
                User projectContributor = projectContributors.get(fileContributor);
                int newCharContribution = fileContributorInfo.totalChar;
                int newNoLinesContribution = fileContributorInfo.noOfLinesContributed;
                projectContributor.updateContribution(newCharContribution, newNoLinesContribution);
            }
        }
    }

    public void run(){
        // todo create myFile objects
        contributionChecker = new ContributionChecker();
        // todo run ContributionChecker on each myFile
        contributionChecker.run();
    }


    public static void checkContribution(){

    }
     */
}
