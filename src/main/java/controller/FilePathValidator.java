package controller;

import java.io.File;

public class FilePathValidator {

    public static boolean isValidFilePath(String filePath){
        File file = new File(filePath);
        return file.isDirectory();
    }
}
