package projectFiles;

import contributionChecker.ContributionChecker;
import contributionChecker.CommitChecker;
import user.*;

import java.util.HashMap;

public class FileInfo {

    private String localPathInCode;
    private String fileName;
    private String commitID;
    private boolean isLatestCommit = false;
    private UserManagement fileContributors;
    private User mostLineContributor = null;
    private User mostCharContributor = null;

    public FileInfo(String pathCode, String file) {
        localPathInCode = pathCode;
        fileName = file;
        fileContributors = new UserManagement();
    }

    public void updateFileContributions() {
        ContributionChecker checker = new ContributionChecker(this);
        String currentCommitID = CommitChecker.obtainCommitId(this);
        if (!(commitID == null) && commitID.equals(currentCommitID)){
            isLatestCommit = true;
            return;
        } else {
            commitID = currentCommitID;
        }
        checker.run();
        if (fileContributors.getUserList().isEmpty()) {
            return;
        }
        updateMostContributorsOfFile();
    }

    public void updateMostContributorsOfFile() {
        for (HashMap.Entry<String, User> entry : fileContributors.getUserList().entrySet()) {
            User currentUser = entry.getValue();
            if (mostCharContributor == null) {
                mostCharContributor = currentUser;
                mostLineContributor = currentUser;
            } else {
                int noOfLines = currentUser.getNoOfLinesContributed();
                int noOfChars = currentUser.getTotalChar();
                int mostLinesContributed = mostLineContributor.getNoOfLinesContributed();
                int mostCharContributed = mostLineContributor.getTotalChar();
                if (noOfChars > mostCharContributed) {
                    mostCharContributor = currentUser;
                }
                if (noOfLines > mostLinesContributed) {
                    mostCharContributor = currentUser;
                }
            }
        }
    }

    public UserManagement getFileContributors() {
        return fileContributors;
    }

    public String getLocalPathInCode() {
        return localPathInCode;
    }

    public String getCommitID(){ return commitID;}

    public String getFileName() {
        return fileName;
    }

    public void setCommitID(String commitID) { this.commitID = commitID;}

    public User getMostLineContributor(){return mostLineContributor;}

    public User getMostCharContributor(){return mostCharContributor;}

    public boolean getCommitStatus(){return isLatestCommit;}

    public void getContributionReport() {

//        if (fileContributors.isEmpty()) {
//            return;
//        }
//        User mostLineUser = null;
//        User mostCharUser = null;
        for (HashMap.Entry<String,User> entry : fileContributors.getUserList().entrySet()) {
            User user = entry.getValue();
//            if (mostLineUser == null) {
//                mostLineUser = user;
//                mostCharUser = user;
//            }
//            if (user.getNoOfLinesContributed() > mostLineUser.getNoOfLinesContributed()) {
//                mostLineUser = user;
//            }
//            if (user.getTotalChar() > mostCharUser.getTotalChar()) {
//                mostCharUser = user;
//            }
            if (user.getNoOfLinesContributed() != 0) {
                System.out.println("User " + user.getId() + " has contributed a total of line: " +
                        user.getNoOfLinesContributed() + " and a total number of " + user.getTotalChar() +
                        " characters to the file.");
            }
        }
        System.out.println("The user who contributed the most lines is " + mostLineContributor.getId()
                + " with " + mostLineContributor.getNoOfLinesContributed() + " lines contributed.");
        System.out.println("The user who contributed the most characters is " + mostCharContributor.getId()
                + " with " + mostCharContributor.getTotalChar() + " characters contributed.");


    }
}

