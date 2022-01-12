package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {

    private static File f;

    public Storage(){
        // todo
    }

    public void run(){

        // todo get file directory & file name

        // todo store output (maybe contribution?) in textbook

    }

    public static File getFile(String path, String fileName){
        fileName = fileName.replaceAll(".java", "");
        String home = path + "\\\\" + fileName + ".txt";
        f = null;
        try {
            f = new File(home);
//            clearContents(f);
        } catch (NullPointerException e) {
            System.out.println("File not found");
        }
        return f;
    }

    public static void clearContents() throws IOException {
        FileWriter fw = new FileWriter(f.getAbsolutePath());
        fw.write("");
        fw.close();
    }

}
