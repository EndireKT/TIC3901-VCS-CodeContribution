package model.storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.fileInfo.FileInfo;

public class ProgressReader {

    private static File file = null;

    public static ArrayList<FileInfo> read(String currentLocalPath) {
        ArrayList<FileInfo> fileInfoHistory = new ArrayList<>();
        initiateRead(fileInfoHistory, currentLocalPath);
        try{
            clearContents(currentLocalPath);
        } catch (IOException e){
            System.out.println("No Storage detected");
        }
        return fileInfoHistory;
    }

    private static void initiateRead(ArrayList<FileInfo> fileInfoHistory,String currentLocalPath){
        Scanner currentFile;
        try{
            ProgressReader.file = TextFile.getFile(currentLocalPath);
            currentFile = new Scanner(ProgressReader.file);
            String[] oneLine = new String[1];
            String pathCode = "";
            String fileName= "";
            String commitID= "";
            String mainContributor= "";
            String fileContent= "";
            while (currentFile.hasNext()){
                oneLine[0] = currentFile.nextLine();
                if(oneLine[0] == ""){
                    continue;
                }
                oneLine = parseIdentifier(oneLine);
                if(oneLine == null){
                    System.out.println("Kindly check Cache file for issue");
                    System.exit(1);
                }
                switch (oneLine[0]){
                    case "File Path":
                        pathCode = oneLine[1];
                        break;
                    case "File Name":
                        fileName = oneLine[1];
                        break;
                    case "CommitID":
                        commitID = oneLine[1];
                        break;
                    case "Main Contributor":
                        mainContributor = oneLine[1];
                        break;
                    case "Content":
                        fileContent = oneLine[1];
                        FileInfo newFile = new FileInfo(pathCode, fileName,
                                commitID, mainContributor,fileContent);
                        fileInfoHistory.add(newFile);
                        pathCode = "";
                        fileName= "";
                        commitID= "";
                        mainContributor= "";
                        fileContent= "";
                        break;
                }
            }
            currentFile.close();
        } catch (IOException e) {
            System.out.println("No existing file found");
        }
    }

    private static String[] parseIdentifier(String[] line){
        try{
            String expected[] = line[0].split(":", 2);
            expected[0] = expected[0].trim();
            expected[1] = expected[1].trim();
            return expected;
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    private static void clearContents(String currentLocalPath) throws IOException {
        file = TextFile.getFile(currentLocalPath);
        FileWriter fw = new FileWriter(file.getAbsolutePath());
        fw.write("");
        fw.close();
    }
}
