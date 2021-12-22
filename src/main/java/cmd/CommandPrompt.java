package cmd;

import java.io.IOException;

public class CommandPrompt {

    // todo some private variables
    private ProcessBuilder pBuilder;

    public CommandPrompt(){
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
}
