package view;

import model.projectFiles.ProjectInfo;
import view.ui.ResultDisplayer;
import view.ui.Ui;

import java.util.ArrayList;

public class ViewUi {
    Ui ui;

    public ViewUi(){
        ui = new Ui();
    }

    public void displayResults(ProjectInfo projectInfo) {
        ResultDisplayer resultDisplayer = new ResultDisplayer(projectInfo);
        resultDisplayer.printIndividualFileContributor();
        resultDisplayer.printContributorFrequency();
        resultDisplayer.printProjectMainContributors();
    }

    public String requestUserForFilePath(){
        return ui.getProjectPath();
    }

    public String requestUserForCommit() {
        return ui.getuserCommit();
    }

    public void showListOfCommitsAndAuthor (ArrayList<String> commitList, ArrayList<String> authorList){
        System.out.println("List of Commit : Author");
        for (int i = 0; i < commitList.size(); i++){
            String commit = commitList.get(i);
            String author = authorList.get(i);
            String format = "%-40s%s%n";
            System.out.printf(format, commit, author);
        }
    }

    public void showErrorInvalidCommitAndAuthor(){
        System.out.println("The commit and author list at the directory is invalid and does not tally");
    }

    public void showErrorInvalidFilePath(){
        System.out.println("The filePath is invalid");
    }

    public void showErrorInvalidGitRepo(){
        System.out.println("The filePath does not contain valid Git Repo");
    }

    public void showInvalidUserStartCommit(){
        System.out.println("You have keyed in an invalid commit.");
    }
}
