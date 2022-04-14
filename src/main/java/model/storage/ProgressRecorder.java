package model.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.fileInfo.FileInfo;

public class ProgressRecorder {

    private static ArrayList<FileInfo> javaFromCommit_CurrentCommit;
    private static File f;
    private static FileWriter fw;

    public ProgressRecorder(ArrayList<FileInfo> javaFromCommit_CurrentCommit) {
        this.javaFromCommit_CurrentCommit = javaFromCommit_CurrentCommit;
        f = null;
        fw = null;
    }

    public static void record(){
        for (FileInfo oneFile : javaFromCommit_CurrentCommit){
            initiateWrite(oneFile);
        }
    }

    private static void initiateWrite(FileInfo file){
        try{
            ProgressRecorder.f = TextFile.getFile(file.getPathCode());
            fw = new FileWriter(ProgressRecorder.f.getAbsolutePath(),true);
            fw.write("File Path: " + file.getPathCode()+ System.lineSeparator());
            fw.write("File Name: " + file.getFileName()+ System.lineSeparator());
            fw.write("CommitID: " + file.getCommitID() + System.lineSeparator());
            fw.write("Main Contributor: " + file.getMainContributor()+ System.lineSeparator());
            fw.write("Content: " + file.getFileContent()+ System.lineSeparator()
                    + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to find file. New file will be attempted to be created at " +
                    file.getPathCode());
        }
    }

    private static void clearContents() throws IOException {
        FileWriter fw = new FileWriter(f.getAbsolutePath());
        fw.write("");
        fw.close();
    }

}
