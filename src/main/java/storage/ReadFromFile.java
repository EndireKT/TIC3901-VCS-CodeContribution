package storage;

import user.User;
import user.UserManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class ReadFromFile {

    private static File f = Storage.getFile();


    public static void initiateRead(UserManagement dataBase){
        Scanner currentFile;
        try{
            currentFile = new Scanner(f);
            currentFile.nextLine();
            while (currentFile.hasNext()){
                String userDetails= currentFile.nextLine();
                parseText(userDetails,dataBase);
            }
            currentFile.close();
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }
    }

    public static void parseText(String userDetails,UserManagement dataBase){
        String[] expected = userDetails.split("\\|");
        dataBase.addContribution(expected[0],Integer.parseInt(expected[1]), Integer.parseInt(expected[2]));
    }

}
