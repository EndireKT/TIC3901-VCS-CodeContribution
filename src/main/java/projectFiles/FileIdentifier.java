package projectFiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import commandprompt.CmdPrompt;

public class FileIdentifier {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    public static ArrayList<FileInfo> getJavaFilesFromPath(
            String pathCode, String commitID, String commitContributor) {

        ArrayList<String> allFiles = getListOfFileNames(pathCode);

        if (allFiles == null) {
            return null;
        }

        ArrayList<FileInfo> javaFiles = new ArrayList<>();
        for (int i = 0; i < allFiles.size(); i++) {
            String fileName = allFiles.get(i);
            if (fileName.endsWith(".java")) {
                FileInfo newFile = new FileInfo(pathCode, fileName, commitID, commitContributor);
                //todo ProgressReader.initiateRead(newFile);
                javaFiles.add(newFile);
            }
        }

        return javaFiles;
    }

    private static ArrayList<String> getListOfFileNames(String pathCode) {
        ArrayList<String> output = new ArrayList<>();
        try {
            Process process = CmdPrompt.navigateToDirectory(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;
            while (hasLine) {
                String currentLine = reader.readLine();
                if (currentLine == null) {
                    hasLine = false;
                    continue;
                }
                output.add(currentLine);
            }
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<FileInfo> getFilesHistory(String pathCode) {

        ArrayList<String> allFiles = getListOfFileNames(pathCode);

        if (allFiles == null) {
            return null;
        }

        ArrayList<FileInfo> txtFiles = new ArrayList<>();
        for (int i = 0; i < allFiles.size(); i++) {
            String fileName = allFiles.get(i);
            if (fileName.endsWith(".txt")) {
                FileInfo newFile = new FileInfo(pathCode, fileName.replaceAll("\\.txt",".java" )
                        , "NIL" , "NIL");
                txtFiles.add(newFile);
            }
        }

        return txtFiles;
    }

}
