package model.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {

    private static File file;

    public static File getFile(String fileName){
//        fileName = fileName.replaceAll("\\.java", ".txt");
        fileName = fileName + "\\\\ProjectCache.txt";
        file = null;
        try {
            file = new File(fileName);
//            clearContents(f);
        } catch (NullPointerException e) {
            System.out.println("File not found, File will be created at " + fileName);
        }
        return file;
    }

    public static void clearContents() throws IOException {
        FileWriter fw = new FileWriter(file.getAbsolutePath());
        fw.write("");
        fw.close();
    }

}
