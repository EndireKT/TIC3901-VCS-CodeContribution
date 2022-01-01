package cmd;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandPromptTest {

    @Test
    void CommandPrompt_gitBlame_success() {
        CommandPrompt commandPrompt = new CommandPrompt();
        String drive = "/c";
        String path = "D:\\My Files\\School Documents\\Repository\\TestBlame";
        String name = "README.md";

        Process process = null;
        try{
            process = commandPrompt.gitBlame(drive,path,name);
            assertEquals(0, process.waitFor());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void CommandPrompt_gitBlame_failure() {
        CommandPrompt commandPrompt = new CommandPrompt();
        String drive = "/c";
        String path = "D:\\My Files\\School Documents\\Repository\\TestBlame";
        String name = "InvalidFileName.md";

        Process process = null;
        try{
            process = commandPrompt.gitBlame(drive,path,name);
            assertNotEquals(0, process.waitFor());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}