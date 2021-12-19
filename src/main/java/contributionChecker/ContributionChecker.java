package contributionChecker;

import parser.Parser;
import ui.Ui;
import user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContributionChecker {
    // todo some private variables
    private ProcessBuilder pBuilder;
    private Scanner inputScanner;
    private Parser parser;
    private Ui ui;
    private Map<String, User> users; // todo maybe this shouldnt be here

    public ContributionChecker() {
        // todo
        users = new HashMap<>();

        pBuilder = new ProcessBuilder();
        inputScanner = new Scanner(System.in);
        parser = new Parser(users);
        ui = new Ui(users);
    }

    public void run() {

        try {
            // todo DUNNO HOW TO DO THIS PART X.X
            pBuilder.command("cmd.exe", "cd D:/My Files/School Documents/Repository/TestBlame", "D:" , "git blame README.md");
            Process process = pBuilder.start();

            parser.readAndParseLine(process);

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ui.getContributionReport();
        }

        // todo call CommandPromptThing

        // todo call UnderstandEachLine

        // todo call User

        // todo call Ui

        // todo call Storage to output

        // todo call Ui to print useful info

    }


}
