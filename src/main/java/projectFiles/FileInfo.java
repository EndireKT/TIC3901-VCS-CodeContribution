package projectFiles;

import user.*;

import java.util.HashMap;
import java.util.Map;

public class FileInfo {

    private String localPathInCode;
    private String fileName;
    private Map<String, User> fileContributors;
    private User mostLineContributor;
    private User mostCharContributor;

    private String drive;
    private String path;
    private String name;

    public FileInfo(String pathCode, String file) {
        localPathInCode = pathCode;
        fileName = file;
        fileContributors = new HashMap<>();
    }

    public void updateFileContributions() {

    }

    public Map<String, User> getFileContributors() {
        return fileContributors;
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
