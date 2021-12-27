package projectFile;

import user.*;

import java.util.HashMap;
import java.util.Map;

public class FileInfo {
    private String localPathInCode;
    private String fileName;
    private Map<String, User> fileContributors;
    private User mostLineContributor;
    private User mostCharContributor;

    public FileInfo(String pathCode, String file) {
        localPathInCode = pathCode;
        fileName = file;
        fileContributors = new HashMap<>();
    }

    public void updateFileContributions() {
        // Run ContributionChecker to update "fileContributors", "mostLineContributor"
        // and "mostCharContributor"
        ContributionChecker.run(this);
    }

    public Map<String, User> getFileContributors() {
        return fileContributors;
    }

}
