package user;

import java.util.ArrayList;

public class User {

    // todo some private variables
    private final String id;
    private int totalChar;
    private ArrayList<Integer> linesContributed;
    private int noOfLinesContributed;

    public User(String id) {
        this.id = id;
    }

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

    public String getId() {
        return id;
    }
}
