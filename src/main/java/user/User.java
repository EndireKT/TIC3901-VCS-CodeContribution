package user;

import java.util.ArrayList;

public class User {

    // todo some private variables
    public String id;
    public int totalChar;
    public ArrayList<Integer> linesContributed;

    public User(String idName, int count, Integer lineNo) {
        id = idName;
        totalChar = count;
        linesContributed = new ArrayList<Integer>();
        linesContributed.add(lineNo);
    }

    public void newContribution(int count, Integer lineNo) {
        totalChar = totalChar + count;
        linesContributed.add(lineNo);
    }

    public void run() {

        // todo update different user
    }


}
