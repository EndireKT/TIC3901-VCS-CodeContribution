package user;

import java.util.ArrayList;

public class User {

    // todo some private variables
    public String id;
    public int totalChar;
    public ArrayList<Integer> linesContributed;
    public int noOfLinesContributed;

    public User(String idName, int count, Integer lineNo) {
        id = idName;
        totalChar = count;
        linesContributed = new ArrayList<>();
        linesContributed.add(lineNo);
        noOfLinesContributed = 1;
    }

    public void newContribution(int count, Integer lineNo) {
        totalChar = totalChar + count;
        linesContributed.add(lineNo);
        noOfLinesContributed++;
    }

    public void updateContribution(int addChar, int addLines) {
        totalChar = totalChar + addChar;
        noOfLinesContributed = noOfLinesContributed + addLines;
    }

    public void run() {

        // todo update different user
    }


}
