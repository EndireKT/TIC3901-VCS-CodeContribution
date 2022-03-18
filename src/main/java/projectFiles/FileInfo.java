package projectFiles;

public class FileInfo {

    private String pathCode;
    private String fileName;
    private String commitID;
    private String mainContributor;
    private String fileContent;

    public FileInfo(String pathCode, String fileName,
                    String commitID, String commitContributor, String fileContent) {
        this.pathCode = pathCode;
        this.fileName = fileName;
        this.commitID = commitID;
        mainContributor = commitContributor;
        this.fileContent = fileContent;
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

    public String getFileContent() {
        return fileContent;
    }

    public void setMainContributor(String newMainContributor) {
        mainContributor = newMainContributor;
    }
}

