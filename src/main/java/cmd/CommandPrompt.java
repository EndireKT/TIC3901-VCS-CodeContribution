package cmd;

import java.io.IOException;

public class CommandPrompt {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    // todo some private variables

    public CommandPrompt() {
        // todo
        pBuilder = new ProcessBuilder();
    }

    public Process gitBlame(String drive, String path, String name) throws IOException {
        String cmd = "cmd.exe";
        StringBuilder filePathGitBlame = new StringBuilder();
        filePathGitBlame.append("cd ");
        filePathGitBlame.append(path);
        filePathGitBlame.append(" && git blame ");
        filePathGitBlame.append(name);

        pBuilder.command(cmd, drive, filePathGitBlame.toString());
        Process process = pBuilder.start();

        return process;
    }

    /*
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
     */
}
