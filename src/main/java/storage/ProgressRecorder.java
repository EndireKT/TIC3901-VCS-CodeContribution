package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import fileInfo.FileInfo;

public class ProgressRecorder {

    private static ArrayList<FileInfo> javaFromCommit_CurrentCommit;
    private static File f = null;
    private static FileWriter fw = null;

    public ProgressRecorder(ArrayList<FileInfo> javaFromCommit_CurrentCommit) {
        this.javaFromCommit_CurrentCommit = javaFromCommit_CurrentCommit;
    }

    public static void record(){
        for (FileInfo oneFile : javaFromCommit_CurrentCommit){
            initiateWrite(oneFile);
        }
    }

    private static void initiateWrite(FileInfo file){
        try{
            f = TextFile.getFile(file.getFilePath());
//            TextFile.clearContents();
            fw = new FileWriter(f.getAbsolutePath(),true);
            fw.write("File Name: " + file.getFileName()+ System.lineSeparator());
            fw.write("CommitID: " + file.getCommitID() + System.lineSeparator());
            fw.write("Main Contributor: " + file.getMainContributor()+ System.lineSeparator()
                    + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to find file. New file will be attempted to be created at " +
                    file.getPathCode());
        }
    }



}
