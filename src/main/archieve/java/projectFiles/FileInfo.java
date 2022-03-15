package projectFiles;

import contributionChecker.ContributionChecker;
import java.util.HashMap;

public class FileInfo {

    private String localPathInCode;
    private String fileName;
    private String commitID;
    private String mainContributor;
    private String fileContent;

    public FileInfo(String pathCode, String file,
                    String commitHash, String commitContributor) {
        localPathInCode = pathCode;
        fileName = file;
        commitID = commitHash;
        mainContributor = commitContributor;
        this.getContentFromFile();
    }

    public String getLocalPathInCode() {
        return localPathInCode;
    }

    public String getCommitID(){ return commitID;}

    public String getFileName() {
        return fileName;
    }

    private void getContentFromFile() {
        // read the file using the localPathInCode
        // update the fileContent field with the contents of the file made into ONE string
    }

    private void updateMainContributor(String newMainContributor){
        mainContributor = newMainContributor;
    }

    public String getMainContributor() {
        return mainContributor;
    }

}

