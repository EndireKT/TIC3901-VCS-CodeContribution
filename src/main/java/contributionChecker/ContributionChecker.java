package contributionChecker;

import java.util.ArrayList;
import java.util.Set;

import fileInfo.FileInfo;

public class ContributionChecker {

    private ProjectContributorEvaluator projectContributorEvaluator;

    /**
     * Compare two String using Levenshtein Distance
     *
     * Compute using the formula:
     * ---- if (LD value > half of total character size in str1 (previous commit))
     *
     * Return true if current committer is the main contributor of the file content
     * ---- LD value is greater
     * Return false if previous committer is the main contributor of the file content
     * ---- LD value is same or lower
     *
     * @param fileContentPreviousCommit String representing the original text (in previous commit)
     * @param fileContentCurrentCommit String representing the edited text (in current commit)
     * @return boolean
     */
    public boolean compareContribution(String fileContentPreviousCommit, String fileContentCurrentCommit) {
        int LD = LevenshteinDistance.computeLevenshteinDistanceDP(fileContentPreviousCommit, fileContentCurrentCommit);
        int charStr2 = fileContentCurrentCommit.length();

        if (LD > charStr2 / 2) {
            return true;
        } else {
            return false;
        }
    }

    public void evaluateFileInfos(ArrayList<FileInfo> filesInfos) {
        projectContributorEvaluator = new ProjectContributorEvaluator(filesInfos);
        projectContributorEvaluator.evaluate();
    }

    public Set<String> getContributorFrequency() {
        return projectContributorEvaluator.getContributorFrequency();
    }

    public ArrayList<String> getProjectMainContributors() {
        return projectContributorEvaluator.getProjectMainContributors();
    }
}