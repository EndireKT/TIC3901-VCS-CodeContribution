package view.ui;

import model.projectFiles.ProjectInfo;
import java.util.Scanner;

public class Ui {

    private static Scanner inputScanner = new Scanner(System.in);
    private ProjectInfo newProject;

    public Ui() {
    }

    public void execute() {
        String localPath = getProjectPath();
        newProject = new ProjectInfo(localPath);
        newProject.getProjectInfo();
    }

    public String getProjectPath() {
        System.out.println("Enter path to file directory to check for contribution:");
        System.out.println("Key-in \"quit\" to leave the program");
        return inputScanner.nextLine().trim();

    }

    public String getuserCommit(){
        System.out.println("Enter a commit hash from above list to begin contribution check:");
        return inputScanner.nextLine().trim();
    }
}
