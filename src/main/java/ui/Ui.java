package ui;

import fileIdentifier.FileIdentifier;
import storage.Storage;
import storage.WriteToFile;
import user.User;

import java.util.Map;

public class Ui {
    // todo some private variables
    private Map<String, User> users; // todo maybe this shouldnt be here
    private FileIdentifier fileIdentifier;

    public Ui(){
        // todo
        fileIdentifier = new FileIdentifier();
    }

    public Ui(Map<String, User> users){
        // todo
        this.users = users;
    }

    public void run(){

        // todo ask user input for folder path

        // todo run FileIdentifier

        // todo return list of java file path

    }

    // todo print useful info

    public void getContributionReport() {
        String text;
        if (users.isEmpty()) {
            return;
        }
        WriteToFile.initiateWrite();
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
            System.out.println("User " + user.id + " has contributed line numbers: " +
                    user.linesContributed + " and a total number of " + user.totalChar +
                    " characters to the file.");
            WriteToFile.UserWrite(user.id, user.linesContributed, user.totalChar);
        }
        text = "The user who contributed the most lines is " + mostLineUser.id
                + " with " + mostLineUser.linesContributed.size() + " lines contributed.";
        System.out.println(text);
//        System.out.println("The user who contributed the most lines is " + mostLineUser.id
//                + " with " + mostLineUser.linesContributed.size() + " lines contributed.");
        WriteToFile.StatsWrite(text);
        text = "The user who contributed the most characters is " + mostCharUser.id
                + " with " + mostCharUser.totalChar + " characters contributed.";
//        System.out.println("The user who contributed the most characters is " + mostCharUser.id
//                + " with " + mostCharUser.totalChar + " characters contributed.");
        System.out.println(text);
        WriteToFile.StatsWrite(text);
    }
}
