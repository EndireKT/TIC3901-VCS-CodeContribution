package projectFile;

// dummy file class for writing ContributionChecker module

import java.util.ArrayList;
import java.util.List;

public class FileToBeChecked {
    private String drive;
    private String path;
    private String name;
    private List<FileLine> lines;

    public FileToBeChecked() {
        drive = "/c";
        path = "D:\\My Files\\School Documents\\Repository\\TestBlame";
        name = "README.md";
    }

    public void addFileLines(ArrayList<String> infoFromGitBlame){
        for (String str : infoFromGitBlame) {
            String[] info = str.split(" ");
            lines.add(new FileLine(info[0], Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3])));
        }
    }

    public String getDrive() {
        return drive;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

}
