package view;

import model.projectFiles.ProjectInfo;

import java.util.ArrayList;

public class ViewUi {

    public ViewUi(){

    }

    public void displayResults(ProjectInfo projectInfo) {
        // todo
    }

    public String requestUserForFilePath(){
        // todo fillthis up
        System.out.println("Key-in \"quit\" to leave the program");
        return null;
    }

    public String requestUserForCommit() {
        // todo
        return null;
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
        System.out.println("The commit and author list at the directory is invalid");
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
