package controller;

import model.Model;
import view.ViewUi;

import java.util.ArrayList;

public class Controller {
    private Model model;
    private ViewUi viewUi;

    public Controller(Model model, ViewUi viewUi) {
        this.model = model;
        this.viewUi = viewUi;
    }

    /**
     * This class control the main logic flow of the entire program
     * <p>
     * It does this in sequence:
     * <p>
     * 1. Get file path from user input (Using View)
     * 1.1. validate if filePath exist
     * 1.2. validate if the path contains valid Git repo (Using Model)
     * 1.3  validate list of commit and author at filepath (Using Model)
     * <p>
     * 3. Ask user which commit to start from (Using View)
     * <p>
     * 4. Initiate progress read, contribution check, progress store (Using Model)
     * <p>
     * 5. Return result to user (Using View)
     */
    public void execute() {

        String filePath = "";
        Boolean isFilePathInValid = true;
        while (isFilePathInValid) {
            filePath = viewUi.requestUserForFilePath();
            model.setPathCodeAndRemoteGitUrl(filePath);
            isFilePathInValid = false;
            if (filePath.equals("quit")){
                return;
            }
            if (!FilePathValidator.isValidFilePath(filePath)) {
                viewUi.showErrorInvalidFilePath();
                isFilePathInValid = true;
                continue;
            }
            if (!model.isValidCommitAndAuthorList()) {
                viewUi.showErrorInvalidCommitAndAuthor();
                isFilePathInValid = true;
                continue;
            }
            if (!model.isValidGitRepo()) {
                viewUi.showErrorInvalidGitRepo();
                isFilePathInValid = true;
                continue;
            }
        }

        ArrayList<String> commitList = model.getListOfCommits();
        ArrayList<String> authorList = model.getListOfAuthors();
        String userStartCommit;
        viewUi.showListOfCommitsAndAuthor(commitList, authorList);
        while (true) {
            userStartCommit = viewUi.requestUserForCommit();
            if (model.isValidCommit(userStartCommit)){
                break;
            }
            viewUi.showInvalidUserStartCommit();
        }

        model.initiateContributionChecker(userStartCommit, filePath);

        viewUi.displayResults(model.getProjectInfo());
    }
}
