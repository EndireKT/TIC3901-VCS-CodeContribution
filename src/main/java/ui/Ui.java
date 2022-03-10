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
        newProject.printContributorsInfo();
    }

}
