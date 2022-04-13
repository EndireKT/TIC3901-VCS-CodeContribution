package view.ui;

import java.util.Scanner;

public class Ui {

    private static Scanner inputScanner = new Scanner(System.in);

    public Ui() {
    }

    public String getProjectPath() {
        System.out.println("Enter path to file directory to check for contribution:");
        System.out.println("Key-in \"quit\" to leave the program");
        String userInput = inputScanner.nextLine().trim();
        return userInput;

    }

    public String getuserCommit(){
        System.out.println("Enter a commit hash from above list to begin contribution check:");
        String userInput = inputScanner.nextLine().trim();
        return userInput;
    }
}
