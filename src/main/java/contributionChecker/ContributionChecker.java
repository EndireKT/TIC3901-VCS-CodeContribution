package contributionChecker;

import cmd.CommandPrompt;
import parser.Parser;
import projectFile.FileToBeChecked;
import storage.Storage;
import ui.Ui;
import user.User;
import user.UserManagement;

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

        Process process = null;

        callCommandPrompt_GitBlame(process);
        callParser_ReadandParseProcess(process);
        callUserManagement_doSomething();
        callStorage_doSomething();
        callUi_getContributionReport();
    }

    private Process callCommandPrompt_GitBlame(Process process){
        try {
            process = commandPrompt.gitBlame(fileToBeChecked.getDrive(), fileToBeChecked.getPath(), fileToBeChecked.getName());
        } catch (Exception e){
            // todo improve error handling later
            System.out.println("Command Prompt has error");
            System.out.println("replace this line with something more useful later");
            e.printStackTrace();
        }

        return process;
    }

    private void callParser_ReadandParseProcess(Process process){
        try {
            parser.readAndParseLine(process);
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
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
