package projectFiles;

import contributionChecker.ContributionChecker;
import user.*;

import java.util.HashMap;

public class FileInfo {

    private String localPathInCode;
    private String fileName;
    private HashMap<String, User> fileContributors; // ksw95, LAPTOP-48KPJ1NS\Kcube
    private User mostLineContributor;
    private User mostCharContributor;

    public FileInfo(String pathCode, String file) {
        localPathInCode = pathCode;
        fileName = file;
        fileContributors = new HashMap<>();
    }

    public void updateFileContributions() {
        ContributionChecker checker = new ContributionChecker(this);
        checker.run();
    }

    public HashMap<String, User> getFileContributors() {
        return fileContributors;
    }

    public String getLocalPathInCode() {
        return localPathInCode;
    }

    public String getFileName() {
        return fileName;
    }
}

