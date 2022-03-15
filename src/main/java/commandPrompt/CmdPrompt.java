package commandPrompt;

import java.io.IOException;

/**
 * This class contains all the git related command used in the project
 */
public class CmdPrompt {
    private static ProcessBuilder pBuilder = new ProcessBuilder();

    public CmdPrompt() {
        pBuilder = new ProcessBuilder();
    }


    /**
     * Initialize a command prompt and execute "git config --get remote.origin.url" in command prompt
     * git config --get remote.origin.url >> get remote project url
     *
     * @param pathCode
     * @return Process
     * @throws IOException
     */
    public static Process getGitRemoteProjectUrl(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && git config --get remote.origin.url";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }

    /**
     * Initialize a command prompt and execute "git log --pretty=%h" in command prompt
     * git log --pretty=%h >> return all commit hash
     *
     * @param pathCode String representing the file path
     * @return Process
     * @throws IOException
     */
    public static Process getProjectCommitHash(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && git log --pretty=%h";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }

    /**
     * Initialize a command prompt and execute "git log --pretty=%cn" in command prompt
     * git log --pretty=%cn >> return all committer name
     *
     * @param pathCode String representing the file path
     * @return Process
     * @throws IOException
     */
    public static Process getCommitterName(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && git log --pretty=%cn";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }

    /**
     * Initialize a command prompt and execute "git checkout" in command prompt
     * git checkout >> changes the current files content to the contents in the commit
     *
     * @param pathCode   String representing the file path
     * @param commitHash String representing the hash (identifier) of the commit
     */
    public static void checkoutCommit(String pathCode, String commitHash) {
        String commandInput = "cd " + pathCode + " && git checkout " + commitHash;
        pBuilder.command("cmd.exe", "/c", commandInput);
    }

    /**
     * Navigate to the directory required in command prompt
     *
     * @param pathCode String representing the file path
     * @return Process
     * @throws IOException
     */
    public static Process navigateToDirectory(String pathCode) throws IOException {
        String commandInput = "cd " + pathCode + " && dir /b";
        pBuilder.command("cmd.exe", "/c", commandInput);
        Process process = pBuilder.start();
        return process;
    }
}
