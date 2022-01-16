package commandPrompt;

import java.io.IOException;

public class CommandPrompt {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    // todo some private variables

    public CommandPrompt() {
        // todo
        pBuilder = new ProcessBuilder();
    }

    public Process gitBlame(String pathCode, String fileName) throws IOException {

        String commandInput = "cd " + pathCode + " && git blame " + fileName;
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();

        return process;
    }

}
