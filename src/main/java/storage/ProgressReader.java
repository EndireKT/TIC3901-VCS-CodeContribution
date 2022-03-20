package storage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fileInfo.FileIdentifier;
import fileInfo.FileInfo;

public class ProgressReader {

    private static File file = null;

    public static ArrayList<FileInfo> read(String currentLocalPath) {
        ArrayList<FileInfo> fileInfoHistory;
        fileInfoHistory = FileIdentifier.getFilesHistory(currentLocalPath);
        for (FileInfo eachFile : fileInfoHistory){
            initiateRead(eachFile);
        }
        return fileInfoHistory;
    }

    private static void initiateRead(FileInfo file){
        Scanner currentFile;
        try{
            ProgressReader.file = TextFile.getFile(file.getFilePath());
            currentFile = new Scanner(ProgressReader.file);
            String userDetails;
            while (currentFile.hasNext()){
                userDetails= currentFile.nextLine();
                if (userDetails.startsWith("CommitID:")){
                    file.setCommitID(parseCommitID(userDetails));
                    continue;
                }
                else if (userDetails.startsWith("Main Contributor:")){
                    file.setMainContributor(parseContributor(userDetails));
                    break;
                } else if(userDetails.equals("")){
                    continue;
                }
            }
            currentFile.close();
        } catch (IOException e) {
            System.out.println("No existing file found for " + file.getFileName());
        }
    }

    private static String parseCommitID(String userDetails){
        String[] expected = userDetails.split("\s+");
        if (expected.length > 1){
            return expected[1].trim();
        }
        return null;
    }

    private static String parseContributor(String userDetails){
        String[] expected = userDetails.split("\s+");
        if (expected.length > 1){
            return expected[2].trim();
        }
        return null;
    }
}
