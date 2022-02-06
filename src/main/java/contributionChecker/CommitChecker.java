package contributionChecker;

import commandPrompt.CommandPrompt;
import projectFiles.FileInfo;
import parser.Parser;

public class CommitChecker {

    private static FileInfo fileInfo;
    private static Process processLog;
    private static Parser parser;
    private static CommandPrompt commandPrompt;
    private static String infoFromGitLog = null;

    public static String obtainCommitId(FileInfo file){
        fileInfo = file;
        callCommandPrompt_GitLog();
        try {
            parser = new Parser();
            infoFromGitLog = parser.obtainCommitHash(processLog);
            System.out.println("Parser complete\n");
        } catch (Exception e) {
            // todo improve error handling later
            System.out.println("Parser has error");
            System.out.println("replace this line with something more useful later");
            e.printStackTrace();
        }
        return infoFromGitLog;
    }


    private static void callCommandPrompt_GitLog() {
        try {
            commandPrompt = new CommandPrompt();
            processLog = commandPrompt.gitLog(fileInfo.getLocalPathInCode(), fileInfo.getFileName());
            System.out.println("Command Prompt Git Log complete\n");
        } catch (Exception e) {
            // todo improve error handling later
            System.out.println("Command Prompt has error");
            System.out.println("replace this line with something more useful later");
            e.printStackTrace();
        }
    }

}
