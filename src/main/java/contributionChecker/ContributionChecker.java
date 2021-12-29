package contributionChecker;

import parser.Parser;
import ui.Ui;
import user.User;
import user.UserManagement;

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
    private UserManagement users2;

    public ContributionChecker() {
        // todo
        users = new HashMap<>();

        //additional
        users2 = new UserManagement(users);

        pBuilder = new ProcessBuilder();
        inputScanner = new Scanner(System.in);
        parser = new Parser(users);
        ui = new Ui(users);
    }

    public void run() {

        try {
            // todo DUNNO HOW TO DO THIS PART X.X
            pBuilder.command("cmd.exe", "/C" ,"cd C:\\Users\\Kcube\\Documents\\GIT\\TestBlame && git blame README.md");
            Process process = pBuilder.start();

            // read contents of file
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
