package fileInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commandprompt.CmdPrompt;

public class FileIdentifier {

    public static ArrayList<FileInfo> getJavaFilesFromPath(
            String pathCode, String commitID, String commitContributor) {

        ArrayList<String> allJavaPaths = getJavaFilesPaths(pathCode);

        if (allJavaPaths == null) {
            return null;
        }

        ArrayList<FileInfo> javaFiles = new ArrayList<>();

        for (int i = 0; i < allJavaPaths.size(); i++) {
            String filePath = allJavaPaths.get(i);
            String[] pathSplit = filePath.split("\\\\");
            List<String> al;
            al = Arrays.asList(pathSplit);
            String fileName = al.get(al.size() - 1);
            File file = new File(filePath);
            String fileContent = JavaFileReader.readFile(file);

            if (fileName.endsWith(".java")) {
                FileInfo newFile = new FileInfo(pathCode, fileName, commitID, commitContributor, fileContent);
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
            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<String> getJavaFilesPaths(String pathCode) {
        ArrayList<String> dirLines = getLinesUsingDirCommand(pathCode);
        return getAllJavaFilesPaths(dirLines, pathCode);
    }

    public static ArrayList<String> getLinesUsingDirCommand(String pathCode) {
        ArrayList<String> output = new ArrayList<>();
        try {
            Process process = CmdPrompt.callDirCommand(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;
            while (hasLine) {
                String currentLine = reader.readLine();
                if (currentLine == null) {
                    hasLine = false;
                    continue;
                }
                currentLine = currentLine.trim().replaceAll(" +", " ");
                output.add(currentLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static ArrayList<String> getAllJavaFilesPaths(ArrayList<String> output, String pathCode) {
        ArrayList<String> javaFiles = new ArrayList<>();
        for (int i = 0; i < output.size(); i++) {
            String current = output.get(i);
            String[] currentSplit = current.split(" ");
            List<String> al;
            al = Arrays.asList(currentSplit);
            String last = al.get(al.size() - 1);
            ArrayList<String> others;
            if (al.contains("<DIR>")) {
                if (!last.equals(".") && !last.equals("..")) {
                    String newPath = pathCode + "\\" + last;
                    others = getJavaFilesPaths(newPath);
                    javaFiles.addAll(others);
                }
            } else if (last.endsWith(".java")) {
                String javaPath = pathCode + "\\" + last;
                javaFiles.add(javaPath);
            }

        }
        return javaFiles;
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
                        , "NIL" , "NIL", "NIL");
                txtFiles.add(newFile);
            }
        }

        return txtFiles;
    }

}
