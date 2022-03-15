package projectFiles;

public class FileInfo {

    private String pathCode;
    private String fileName;
    private String commitID;
    private String mainContributor;

    public FileInfo(String pathCode, String file,
                    String commitHash, String commitContributor) {
        this.pathCode = pathCode;
        fileName = file;
        commitID = commitHash;
        mainContributor = commitContributor;
        //todo this.getContentFromFile();
    }

    public String getPathCode() {
        return pathCode;
    }

    public String getCommitID() {
        return commitID;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath(){
        return pathCode + "\\\\" + fileName;
    }

    public String getMainContributor() {
        return mainContributor;
    }



    public void setMainContributor(String newMainContributor) {
        mainContributor = newMainContributor;
    }
}

