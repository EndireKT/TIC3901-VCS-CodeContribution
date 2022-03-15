package projectFiles;

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
     * Check whether committerList has contents or empty
     *
     * @param committerList ArrayList<String> containing the list of commit hash
     * @return boolean true if the list is NOT empty; false if the list is empty
     */
    public static boolean isCommitterExist(ArrayList<String> committerList) {
        if (committerList.isEmpty()) {
            System.out.println("Unable to check contribution due to missing Commit details");
            return false;
        }
        return true;
    }

    /**
     * Check whether the size of commitlist is equals to committerlist
     * Return true if the two list has same size, indicating that the extracted commit detail is valid
     *
     * @param commitList ArrayList<String> containing the list of commit hash
     * @param committerList ArrayList<String> containing the list of commit hash
     * @return boolean true if the two list has same size; false if otherwise
     */
    public static boolean isTwoListSizeEqual(ArrayList<String> commitList, ArrayList<String> committerList) {
        if (commitList.size() != committerList.size()) {
            System.out.println("Commit details do not tally.");
            return false;
        }
        return true;
    }
}
