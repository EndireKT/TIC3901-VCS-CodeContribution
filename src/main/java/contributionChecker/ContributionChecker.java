package contributionChecker;

import projectFiles.FileInfo;

public class ContributionChecker {

    public void checkContributionBetweenTwoFileVersions(FileInfo fileFromOlderCommit,
                                                        FileInfo fileFromNewerCommit) {

        // Check LevenshteinDistance between the contents of the two files
        // Update the "mainContributor" in "fileFromNewerCommit" with who contributed more
        // whether it's the previous main contributor or the latest committer

    }

}
