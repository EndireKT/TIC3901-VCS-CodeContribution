/*
package parser;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {

    // todo some private variables

    private BufferedReader reader;
    private InputStreamReader inputStreamReader;

    public Parser(){

    }

    public ArrayList<String> readAndParseLine(Process process){
        inputStreamReader = new InputStreamReader(process.getInputStream());
        reader = new BufferedReader(inputStreamReader);

        ArrayList<String> parsedInfo = new ArrayList<>();

        boolean hasLine = true;

        try {
            while (hasLine) {
                String line = reader.readLine();
                if (line == null) {
                    hasLine = false;
                    continue;
                }

                if (line.startsWith("00000000")) {
                    continue;
                }

                String extractedInfo = parseLine(line);

                if (!extractedInfo.isEmpty()){
                    parsedInfo.add(extractedInfo);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return parsedInfo;
        }
    }

    public String parseLine(String line) {

        line = line.replaceAll("(^\\s+|\\s+$)", "");
        int a = line.indexOf("(");
        int b = line.indexOf("\s");
        String temp = line.substring(b,a);
        if (!temp.isBlank() || temp == "\s"){
            line = line.replaceAll(temp," ");
        }
//        String[] parts = line.replaceAll("(^\\s+|\\s+$)", "").split("\\s+");
        String[] parts = line.split("\\s+");
        int numOfParts = parts.length;

        if (numOfParts < 7){
            return "";
        }

        String userId = parts[1].substring(1);
        String lineNo = parts[5].substring(0, parts[5].length() - 1);
        String lineContent = parts[6];
        for (int i = 7; i < numOfParts; i++){
            lineContent = lineContent + parts[i];
        }
        String noOfChar = Integer.toString(lineContent.length());

        String parseInfo = userId + " " + lineNo + " " + noOfChar + " " + lineContent;
        System.out.println(parseInfo);
        return parseInfo;
    }

    public String obtainCommitHash(Process processLog){
        inputStreamReader = new InputStreamReader(processLog.getInputStream());
        reader = new BufferedReader(inputStreamReader);

        String hashKey = null;

        boolean hasLine = true;

        try {
            while (hasLine) {
                String line = reader.readLine();
                if (line == null) {
                    hasLine = false;
                    continue;
                } else if (line.startsWith("commit"))
                {
                    String[] parts = line.split("\\s+");
                    hashKey = parts[1];
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return hashKey;
        }
    }
}

 */
