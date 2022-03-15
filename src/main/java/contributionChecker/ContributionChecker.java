package contributionChecker;

import java.util.ArrayList;

import projectFiles.FileInfo;

public class ContributionChecker {

    public Boolean compareContribution(String fileAContent, String fileBContent) {
        return LevenshteinDistance.compareContribution(fileAContent, fileBContent);
    }

    public ArrayList<String> compareFileMainContributor(ArrayList<FileInfo> filesInfos) {
        return ProjectContributorEvaluator.evaluate(filesInfos);
    }
}
