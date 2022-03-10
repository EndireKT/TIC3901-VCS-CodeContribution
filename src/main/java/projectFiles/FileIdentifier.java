package projectFiles;

import storage.ProgressReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileIdentifier {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    public static ArrayList<FileInfo> getJavaFilesFromPath(String pathCode, String commitID,
                                                           String commitContributor) {
        ArrayList<String> allFiles = getListOfFileNames(pathCode);
        if (allFiles == null) {
            return null;
        }
        ArrayList<FileInfo> javaFiles = new ArrayList<>();
        for(int i = 0; i < allFiles.size(); i++) {
            String fileName = allFiles.get(i);
            if (fileName.endsWith(".java")) {
                FileInfo newFile = new FileInfo(pathCode, fileName, commitID, commitContributor);
                ProgressReader.initiateRead(newFile);
                javaFiles.add(newFile);
            }
        }
        return javaFiles;
    }

    private static ArrayList<String> getListOfFileNames(String pathCode) {
        String commandInput = "cd " + pathCode + " && dir /b";
        pBuilder.command("cmd.exe", "/c", commandInput);
        ArrayList<String> output = new ArrayList<>();
        try {
            Process process = pBuilder.start();
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
}
