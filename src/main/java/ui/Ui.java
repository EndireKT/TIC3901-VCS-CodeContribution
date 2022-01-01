package ui;

import projectFiles.FileIdentifier;

import java.util.Scanner;

public class Ui {
    private FileIdentifier fileIdentifier;
    private static Scanner inputScanner = new Scanner(System.in);

    public Ui(){
    }


    public void run(){

        // todo ask user input for folder path
        // todo return list of java file path

    }

    public static String getProjectPath() {
        System.out.println("Enter path to file directory to check for contribution:");
        String localPath = inputScanner.nextLine().trim();
        // assume user input legit path
        // todo validate the path
        return localPath;
    }

    public static String getFileName() {
        System.out.println("Enter java file name in the directiory for checking contribution:");
        String fileName = inputScanner.nextLine().trim();
        return fileName;
    }

    // todo print useful info
    public void getContributionReport() {

        /*
        if (users.isEmpty()) {
            return;
        }
        User mostLineUser = null;
        User mostCharUser = null;
        for (Map.Entry<String,User> entry : users.entrySet()) {
            User user = entry.getValue();
            if (mostLineUser == null) {
                mostLineUser = user;
                mostCharUser = user;
            }
            if (user.linesContributed.size() > mostLineUser.linesContributed.size()) {
                mostLineUser = user;
            }
            if (user.totalChar > mostCharUser.totalChar) {
                mostCharUser = user;
            }
            if (user.linesContributed != null) {
                System.out.println("User " + user.id + " has contributed line numbers: " +
                        user.linesContributed + " and a total number of " + user.totalChar +
                        " characters to the file.");
            }
        }
        System.out.println("The user who contributed the most lines is " + mostLineUser.id
                + " with " + mostLineUser.noOfLinesContributed + " lines contributed.");
        System.out.println("The user who contributed the most characters is " + mostCharUser.id
                + " with " + mostCharUser.totalChar + " characters contributed.");

        */
    }
}
