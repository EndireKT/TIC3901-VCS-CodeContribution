package commandPrompt;

import java.io.IOException;

public class CommandPrompt {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    // todo some private variables

    public CommandPrompt() {
        // todo
        pBuilder = new ProcessBuilder();
    }

    /*
    public Process gitBlame(String pathCode, String fileName) throws IOException {

        String commandInput = "cd " + pathCode + " && git blame " + fileName;
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();

        return process;
    }

    public Process gitLog(String pathCode, String fileName) throws IOException {

        String commandInput = "cd " + pathCode + " && git log " + fileName;
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();

        return process;
    }


     */

    public static Process getProjectCommitHash(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && git log --pretty=%h";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }

    public static Process getCommitterName(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && git log --pretty=%cn";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }

    public static void checkoutCommit(String pathCode, String commitHash) {
        String commandInput = "cd " + pathCode + " && git checkout " + commitHash;
        pBuilder.command("cmd.exe", "/c", commandInput);
    }

}