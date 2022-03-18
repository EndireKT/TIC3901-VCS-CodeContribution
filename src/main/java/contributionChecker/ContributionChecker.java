package contributionChecker;

import java.util.ArrayList;

import projectFiles.FileInfo;

public class ContributionChecker {

    /**
     * Compare two String using Levenshtein Distance
     *
     * Return true if current committer is the main contributor of the file content
     * Return false if previous committer is the main contributor of the file content
     *
     * @param fileContentPreviousCommit String representing the original text (in previous commit)
     * @param fileContentCurrentCommit String representing the edited text (in current commit)
     * @return boolean
     */
    public Boolean compareContribution(String fileContentPreviousCommit, String fileContentCurrentCommit) {
        return LevenshteinDistance.compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
    }

    public ArrayList<String> compareFileMainContributor(ArrayList<FileInfo> filesInfos) {
        return ProjectContributorEvaluator.evaluate(filesInfos);
    }
}
