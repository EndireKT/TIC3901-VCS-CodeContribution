package model.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    private static File file;

    public static File getFile(String fileName){
        fileName = fileName.replaceAll("\\.java", ".txt");
        file = null;
        try {
            file = new File(fileName);
//            clearContents(f);
        } catch (NullPointerException e) {
            System.out.println("File not found");
        }
        return file;
    }

    public static void clearContents() throws IOException {
        FileWriter fw = new FileWriter(file.getAbsolutePath());
        fw.write("");
        fw.close();
    }

}
