package projectFile;

// dummy file class for writing ContributionChecker module

public class FileToBeChecked {
    private String drive;
    private String path;
    private String name;

    public FileToBeChecked(){
        drive = "/c";
        path = "D:\\My Files\\School Documents\\Repository\\TestBlame";
        name = "README.md";
    }

    public String getDrive(){
        return drive;
    }

    public String getPath(){
        return path;
    }

    public String getName(){
        return name;
    }

}
