package parser;

import user.User;
import user.UserManagement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Parser {

    // todo some private variables
    private BufferedReader reader;
    private UserManagement userManagement;
    private Map<String, User> users; // todo maybe this shouldnt be here

    public Parser(Map<String, User>  myUsers){
        // todo
        this.users = myUsers;
        userManagement = new UserManagement(users);
    }

    public void run(){

        // todo break down each line into segments of useful info

        // todo Call Praser for each line

        // todo Return useful info for each line

    }

    public void readAndParseLine(Process process){
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        boolean hasLine = true;

        try {
            while (hasLine) {
                String line = reader.readLine();
                if (line == null) {
                    hasLine = false;
                    continue;
                }
                parseLine(line);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void parseLine(String line) {
        String[] parts = line.split(" ");
        if (!isCommitted(parts[0])){
            return;
        }
        String id = parts[1].substring(1).trim();
        String lineNo;
        boolean isEmpty = isEmptyLine(parts[parts.length - 1]);
        int charCount = 0;
        if (!isEmpty) {
            lineNo = parts[parts.length - 2].substring(0, 1);
            charCount = parts[parts.length - 1].length();
        } else {
            lineNo = parts[parts.length - 1].substring(0, 1);
        }
        userManagement.addContribution(id, Integer.parseInt(lineNo), charCount);
    }

    public boolean isCommitted(String part) {
        try {
            if (Integer.parseInt(part) == 0){
                return false;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return true;
    }

    public boolean isEmptyLine(String line) {
        try {
            Integer.parseInt(Character.toString(line.charAt(0)));
        } catch (NumberFormatException e) {
            return false;
        }
        Character check = line.charAt(1);
        if (check.equals(')')) {
            return true;
        }
        return false;
    }
}
