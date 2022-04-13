package ui;

import org.junit.jupiter.api.Test;
import model.projectFiles.ProjectInfo;
import view.ui.ResultDisplayer;

import java.util.Scanner;

class UiTest {

    private static Scanner inputScanner = new Scanner(System.in);
    private ProjectInfo newProject;

    @Test
    void execute() {
        String localPath = "D:\\My Files\\School Documents\\Repository\\TIC3901_TestRepo";
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

    @Test
    void main_Test() {
        UiTest uiTest = new UiTest();
        uiTest.execute();
    }
}