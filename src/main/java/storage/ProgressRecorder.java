package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import projectFiles.FileInfo;

import user.User;

public class ProgressRecorder {

    private static File f = null;
    private static FileWriter fw = null;

    public static void initiateWrite(FileInfo file){
        try{
            f = Storage.getFile(file.getLocalPathInCode(),file.getFileName());
            Storage.clearContents();
            fw = new FileWriter(f.getAbsolutePath(),true);
            fw.write("User | Total Characters Contributed | Total Lines Contributed | List of Lines " +
                    "Contributed" + System.lineSeparator());
            writeUsers(file.getFileContributors().getUserList());
            writeStats(file.getMostCharContributor(), file.getMostLineContributor());
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to find file. New file will be attempted to be created at" +
                    file.getLocalPathInCode());
        }
    }

    public static void writeUsers(HashMap<String, User> fileContributors){
        try{
            for (HashMap.Entry<String,User> entry : fileContributors.entrySet()){
                User user = entry.getValue();
                fw.write(user.getId() + " | " + user.getTotalChar() + " | "
                        + user.getNoOfLinesContributed() + " | " + user.getLinesContributed()
                        + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }

    }

    public static void writeStats(User mostChar, User mostLines){
        try{
            fw.write(System.lineSeparator());
            fw.write("The user who contributed the most characters is " + mostChar.getId()
                    + " with " + mostChar.getTotalChar() + " characters contributed.");
            fw.write(System.lineSeparator());
            fw.write("The user who contributed the most lines is " + mostLines.getId()
                    + " with " + mostLines.getNoOfLinesContributed() + " lines contributed.");
            fw.close();
        } catch (IOException e) {
            System.out.println("No Existing File. New file will be created");
        }

    }
}
