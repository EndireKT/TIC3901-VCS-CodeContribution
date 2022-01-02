package user;

import java.util.ArrayList;

public class User {

    // todo some private variables
    private final String id; // ksw95
    private int totalChar; // 5 -> 10 -> 15
    private ArrayList<Integer> linesContributed; // 1 -> 1,3 -> 1,3,5
    private int noOfLinesContributed; // 1 -> 2 -> 3

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
