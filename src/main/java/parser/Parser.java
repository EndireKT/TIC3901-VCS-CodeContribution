package parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Parser {

    // todo some private variables

    private BufferedReader reader;
    private InputStreamReader inputStreamReader;

    public Parser(){

    }

    public ArrayList<String> readAndParseLine(Process process){
        inputStreamReader = new InputStreamReader(process.getInputStream());
        reader = new BufferedReader(inputStreamReader);

        ArrayList<String> arrayList = new ArrayList<>();

        boolean hasLine = true;

        try {
            while (hasLine) {
                String line = reader.readLine();
                if (line == null) {
                    hasLine = false;
                    continue;
                }

                String extractedInfo = parseLine(line);
                if (!extractedInfo.isEmpty()){
                    arrayList.add(extractedInfo);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            return arrayList;
        }
    }

    public String parseLine(String line) {

        String[] parts = line.replaceAll("(^\\s+|\\s+$)", "").split("\\s+");
        int numOfParts = parts.length;

        if (numOfParts != 7){
            return "";
        }

        String userId = parts[1].substring(1);
        String lineNo = parts[numOfParts-2].substring(0,1);
        String lineContent = parts[numOfParts-1];
        String noOfChar = Integer.toString(lineContent.length());

        return userId + " " + lineNo + " " + lineContent + " " + noOfChar;
    }
}
