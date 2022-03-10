package ui;

import projectFiles.ProjectInfo;

import java.io.IOException;
import java.util.Scanner;

public class Ui {
    private static Scanner inputScanner = new Scanner(System.in);

    public static String getProjectPath() {
        System.out.println("Enter path to file directory to check for contribution:");
        String localPath = inputScanner.nextLine().trim();
        // assume user input legit path
        // todo validate the path
        return localPath;
    }

    public static String getFileName() {
        System.out.println("Enter java file name in the directory for checking contribution:");
        String fileName = inputScanner.nextLine().trim();
        return fileName;
    }

    public static void main(String args[]) {

        String localPath = getProjectPath();
        ProjectInfo newProject = new ProjectInfo(localPath);
        newProject.getProjectInfo();
        if (newProject == null) {
            System.out.println("Failed to check project");
        }
    }

    /*
    // todo print useful info
    public void getContributionReport() {


        String text;
        if (users.isEmpty()) {
            return;
        }
        WriteToFile.initiateWrite();
        User mostLineUser = null;
        User mostCharUser = null;
        for (Map.Entry<String,User> entry : users.entrySet()) {
            User user = entry.getValue();
            if (mostLineUser == null) {
                mostLineUser = user;
                mostCharUser = user;
            }
            if (user.linesContributed.size() > mostLineUser.linesContributed.size()) {
                mostLineUser = user;
            }
            if (user.totalChar > mostCharUser.totalChar) {
                mostCharUser = user;
            }
            if (user.linesContributed != null) {
                System.out.println("User " + user.id + " has contributed line numbers: " +
                        user.linesContributed + " and a total number of " + user.totalChar +
                        " characters to the file.");
            }
        }
        System.out.println("The user who contributed the most lines is " + mostLineUser.id
                + " with " + mostLineUser.noOfLinesContributed + " lines contributed.");
        System.out.println("The user who contributed the most characters is " + mostCharUser.id
                + " with " + mostCharUser.totalChar + " characters contributed.");


    }
    */
}
