package model.projectFiles;

import java.util.ArrayList;

public class RepoValidator {

    /**
     * Check whether Project has a Git remote repo
     *
     * @param remoteRepoGitUrl
     * @return boolean true if remote git repo exist; false if remote git does not exist
     */
    public static boolean isRemoteGitRepoExist(String remoteRepoGitUrl) {
        if (remoteRepoGitUrl == null) {
            System.out.println("Can't check contribution, project does not exist on Github.");
            return false;
        }
        return true;
    }

    /**
     * Check whether commitList has contents or empty
     *
     * @param commitList ArrayList<String> containing the list of commit hash
     * @return boolean true if the list is NOT empty; false if the list is empty
     */
    public static boolean isCommitExist(ArrayList<String> commitList) {
        if (commitList.isEmpty()) {
            System.out.println("Unable to check contribution due to missing Commit details");
            return false;
        }
        return true;
    }

    /**
     * Check whether authorList has contents or empty
     *
     * @param authorList ArrayList<String> containing the list of commit hash
     * @return boolean true if the list is NOT empty; false if the list is empty
     */
    public static boolean isAuthorExist(ArrayList<String> authorList) {
        if (authorList.isEmpty()) {
            System.out.println("Unable to check contribution due to missing Commit details");
            return false;
        }
        return true;
    }

    /**
     * Check whether the size of commitlist is equals to authorList
     * Return true if the two list has same size, indicating that the extracted commit detail is valid
     *
     * @param commitList ArrayList<String> containing the list of commit hash
     * @param authorList ArrayList<String> containing the list of author
     * @return boolean true if the two list has same size; false if otherwise
     */
    public static boolean isTwoListSizeEqual(ArrayList<String> commitList, ArrayList<String> authorList) {
        if (commitList.size() != authorList.size()) {
            return false;
        }
        return true;
    }
}
