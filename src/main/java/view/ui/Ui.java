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

        if (newProject == null) {
            System.out.println("Failed to check project");
        }

        ResultDisplayer resultDisplayer = new ResultDisplayer(newProject);
        resultDisplayer.printIndividualFileContributor();
        resultDisplayer.printContributorFrequency();
        resultDisplayer.printProjectMainContributors();
    }

    private static String getProjectPath() {
        System.out.println("Enter path to file directory to check for contribution:");
        String localPath = inputScanner.nextLine().trim();
        // todo validate the path
        return localPath;
    }

    public static void main(String[] args) {
        Ui ui = new Ui();
        ui.execute();
    }
}
