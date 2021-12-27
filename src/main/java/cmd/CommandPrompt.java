package cmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandPrompt {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    public static String getGitRemoteProjectURL(String pathCode) {
        String commandInput = "cd " + pathCode + " && git config --get remote.origin.url";
        pBuilder.command("cmd.exe", "/c", commandInput);
        try {
            Process process = pBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String remoteURL = reader.readLine();
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
            return remoteURL;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<String> callGitBlame(String pathCode, String fileName) {
        String commandInput = "cd " + pathCode + " && git blame " + fileName;
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void run(){

        // todo run git blame

        // todo return whatever from command prompt
    }
}
