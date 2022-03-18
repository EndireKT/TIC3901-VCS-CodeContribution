package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    private static File f;

    public static File getFile(String fileName){
        fileName = fileName.replaceAll("\\.java", ".txt");
        f = null;
        try {
            f = new File(fileName);
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
