package storage;

import projectFiles.FileInfo;
import user.User;
import user.UserManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgressReader {

    private static File f = null;

    public static void initiateRead(FileInfo file){
        Scanner currentFile;
        try{
            f = Storage.getFile(file.getLocalPathInCode(),file.getFileName());
            currentFile = new Scanner(f);
            currentFile.nextLine();
            while (currentFile.hasNext()){
                String userDetails= currentFile.nextLine();
                if (userDetails.startsWith("The user who")){
                    break;
                } else if(userDetails.equals("")){
                    continue;
                }
                parseText(userDetails,file.getFileContributors().getUserList());
            }
            currentFile.close();
        } catch (IOException e) {
            System.out.println("No existing file found for " + file.getFileName());
        }
    }

    public static void parseText(String userDetails, HashMap<String, User> fileContributors){
        String[] expected = userDetails.split("\\|");
        User newUser = new User(expected[0].trim(), Integer.parseInt(expected[1].trim()),
                Integer.parseInt(expected[2].trim()));
        newUser.populateLines(Integer.parseInt(expected[2].trim()));
        fileContributors.put(newUser.getId(), newUser);
    }

}
