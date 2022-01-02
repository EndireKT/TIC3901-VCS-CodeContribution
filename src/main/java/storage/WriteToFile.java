package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import user.User;

public class WriteToFile {

    private static File f = Storage.getFile();

    public static void initiateWrite(){
        try{
            Storage.clearContents();
            FileWriter fw = new FileWriter(f.getAbsolutePath(),true);
            fw.write("User | Total Lines Contributed | Total Characters Contributed"
                    + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }
    }

    public static void UserWrite(String userID, ArrayList<Integer> linesContributed, Integer userChar){
        try{
            FileWriter fw = new FileWriter(f.getAbsolutePath(),true);
            fw.write(userID + " | " + linesContributed + " | " + userChar
                    + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }

    }

    public static void StatsWrite(String text){
        try{
            FileWriter fw = new FileWriter(f.getAbsolutePath(),true);
            fw.write(System.lineSeparator());
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }

    }
}
