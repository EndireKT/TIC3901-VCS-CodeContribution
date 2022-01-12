package projectFiles;

import storage.WriteToFile;
import user.User;
import user.UserManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ProjectInfo {

    private String currentLocalPath;
    private String remoteRepoGitURL;
    ArrayList<FileInfo> javaFiles;
    private HashMap<String, User> projectContributors;
//    private UserManagement projectContributors;
    User mostLineContributor;
    User mostCharContributor;

    public ProjectInfo(String localPath, String pathCode){
        // Set path info
        currentLocalPath = localPath;
        remoteRepoGitURL = getGitRemoteProjectURL(pathCode);
        this.addJavaFilesToProjectInfo(pathCode);
    }

    public static ProjectInfo getProjectInfo(String localPath) {

        String pathCode = getLocalPathInCode(localPath);
        //why create a new instance of projectInfo here
        ProjectInfo newProject = new ProjectInfo(localPath, pathCode);
        if (newProject.hasRemoteGitRepo() == false) {
            System.out.println("Can't check contribution, project does not exist on Github.");
            return null;
        }
        if (newProject.hasJavaFiles() == false) {
            System.out.println("Project has no java files to check for contribution.");
            return null;
        }
        newProject.updateProjectContributions();
        return newProject;
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

    // Check whether Project has a Git remote repo
    private boolean hasRemoteGitRepo() {
        if (remoteRepoGitURL == null) {
            return false;
        }
        return true;
    }

    // Calls fileIdentifier to get all the fileInfo of the Java files inside the Project
    private void addJavaFilesToProjectInfo(String pathCode) {
        javaFiles = FileIdentifier.getJavaFilesFromPath(pathCode);
    }

    // Check whether Project has any Java Files
    private boolean hasJavaFiles() {
        if (javaFiles == null) {
            return false;
        }
        return true;
    }

    // update projectContributors, mostLineContributor & mostCharContributor
    // 1. Loop through each java file and calls ContributionChecker for each file
    // 2. When each file get updated by ContributionChecker,
    // this Project File gets updated as well
    public void updateProjectContributions() {
        projectContributors = new HashMap<>();
        for (int i = 0; i < javaFiles.size(); i++) {
            FileInfo file = javaFiles.get(i);
            file.updateFileContributions();
            HashMap<String, User> fileUsers = file.getFileContributors();
            if (!fileUsers.isEmpty()){
                file.getContributionReport();
                WriteToFile.initiateWrite(file);
                this.addContributionsFromFile(fileUsers);
            }
        }
    }

    // Checks HashMap input against instance of HashMap in ProjectInfo object
    // if user exist in both HashMap, update the contributions in the ProjectInfo HashMap
    // with the input HashMap
    // if user does not exist in ProjectInfo HashMap
    // add new user with contribution to ProjectInfo HashMap
    private void addContributionsFromFile(HashMap<String, User> fileContributors) {
        for (HashMap.Entry<String, User> entry : fileContributors.entrySet()) {
            String fileContributor = entry.getKey();
            User fileContributorInfo = entry.getValue();
            boolean isNewUser = !projectContributors.containsKey(fileContributor);
//            boolean isNewUser = !projectContributors.isUserExist(fileContributor);
            if (isNewUser) {
                projectContributors.put(fileContributor, fileContributorInfo);
            } else {
                User projectContributor = projectContributors.get(fileContributor);
//                User projectContributor = projectContributors.getUser(fileContributor);
                int newCharContribution = fileContributorInfo.getTotalChar();
                int newNoLinesContribution = fileContributorInfo.getNoOfLinesContributed();
                projectContributor.updateContribution(newCharContribution, newNoLinesContribution);
            }
        }
    }

}
