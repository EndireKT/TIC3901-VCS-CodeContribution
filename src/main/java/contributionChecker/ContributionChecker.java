package contributionChecker;

import cmd.CommandPrompt;
import parser.Parser;
import projectFile.FileToBeChecked;
import storage.Storage;
import ui.Ui;
import user.User;
import user.UserManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContributionChecker {
    // todo some private variables
    private FileToBeChecked fileToBeChecked;
    private CommandPrompt commandPrompt;
    private Parser parser;
    private UserManagement userManagement;
    private Ui ui;
    private Storage storage;

    private Process process;
    private ArrayList<String> infoFromGitBlame = null;

    private Scanner inputScanner;
    private Map<String, User> users; // todo maybe this shouldnt be here

    // may be deleted later
    public ContributionChecker() {
        // todo
        users = new HashMap<>();

        inputScanner = new Scanner(System.in);
        parser = new Parser(users);
        ui = new Ui(users);
    }

    public ContributionChecker(FileToBeChecked fileToBeChecked) {
        // todo
        this.fileToBeChecked = fileToBeChecked;

        commandPrompt = new CommandPrompt();
        parser = new Parser();
        userManagement = new UserManagement();
        ui = new Ui();
        storage = new Storage();
    }

    public void run() {

        process = null;

        callCommandPrompt_GitBlame();
        callParser_ReadAndParseProcess();
        callUserManagement_doSomething();
        callStorage_doSomething();
        callUi_getContributionReport();
    }

    private void callCommandPrompt_GitBlame(){
        try {
            process = commandPrompt.gitBlame(fileToBeChecked.getDrive(), fileToBeChecked.getPath(), fileToBeChecked.getName());
            System.out.println("Command Prompt Git Blame complete\n");
        } catch (Exception e){
            // todo improve error handling later
            System.out.println("Command Prompt has error");
            System.out.println("replace this line with something more useful later");
            e.printStackTrace();
        }
    }

    private void callParser_ReadAndParseProcess(){
        try {
            infoFromGitBlame = parser.readAndParseLine(process);
            System.out.println("Parser complete\n");
        } catch (Exception e){
            // todo improve error handling later
            System.out.println("Parser has error");
            System.out.println("replace this line with something more useful later");
            e.printStackTrace();
        }
    }

    private void callUserManagement_doSomething(){
        // todo call user
        userManagement.run();
    }

    private void callStorage_doSomething(){
        // todo call Storage to output
        storage.run();
    }

    private void callUi_getContributionReport(){
        // todo call Ui to print useful info
        ui.getContributionReport();
    }

}
