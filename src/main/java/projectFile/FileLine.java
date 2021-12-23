package projectFile;

import user.User;

public class FileLine {
    private String userId;
    private int lineNo;
    private String lineContent;
    private int noOfChar;
    private User owner;

    public FileLine(String userId, int lineNo, String lineContent, int noOfChar) {
        this.userId = userId;
        this.lineNo = lineNo;
        this.lineContent = lineContent;
        this.noOfChar = noOfChar;
    }
}
