package model.projectFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.commandprompt.CmdPrompt;

public class CListGenerator {

    @org.jetbrains.annotations.Nullable
    public static ArrayList<String> getCommitList(String pathCode) {
        try {
            ArrayList<String> commits = new ArrayList<>();
            Process process = CmdPrompt.getProjectCommitHash(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;

            while (hasLine) {
                String commitHash = reader.readLine();
                if (commitHash == null) {
                    hasLine = false;
                    continue;
                }
                commits.add(commitHash);
            }
            return commits;
        } catch (IOException e) {
            System.out.println("Unable to get commit hashes");
            return null;
        }
    }

    @org.jetbrains.annotations.Nullable
    public static ArrayList<String> getAuthorList(String pathCode) {
        try {
            ArrayList<String> authors = new ArrayList<>();
            Process process = CmdPrompt.getCommitterName(pathCode);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            boolean hasLine = true;

            while (hasLine) {
                String committerName = reader.readLine();
                if (committerName == null) {
                    hasLine = false;
                    continue;
                }
                authors.add(committerName);
            }
            return authors;
        } catch (IOException e) {
            System.out.println("Unable to get authors");
            return null;
        }
    }


}
