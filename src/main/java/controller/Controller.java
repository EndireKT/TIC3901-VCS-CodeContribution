package controller;

import model.Model;
import view.ViewUi;

public class Controller {
    private Model model;
    private ViewUi viewUi;

    public Controller(Model model, ViewUi viewUi) {
        this.model = model;
        this.viewUi = viewUi;
    }

    /**
     * This class control the main logic flow of the entire program
     *
     * It does this in sequence:
     *
     * 1. Get file path from user input (Using View)
     * 1.1. validate if filePath exist
     * 1.2. validate if the path contains valid Git repo (Using Model)
     *
     * 2. Get commit and committerlist (Using Model)
     * 2.1 validate list (Using Model)
     *
     * 3. Ask user which commit to start from (Using View)
     *
     * 4. Initiate progress read, contribution check, progress store (Using Model)
     *
     * 5. Return result to user (Using View)
     */
    public void execute() {

        String filePath = viewUi.requestUserForFilePath();
        while (!FilePathValidator.isValidFilePath(filePath)) {
            filePath = viewUi.requestUserForFilePath();
        }

        String 
    }
}
