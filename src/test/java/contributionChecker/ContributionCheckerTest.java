package contributionChecker;

import org.junit.jupiter.api.Test;

class ContributionCheckerTest {

    @Test
    void run_unitrun() {
        FileToBeChecked fileToBeChecked = new FileToBeChecked();
        ContributionChecker contributionChecker = new ContributionChecker(fileToBeChecked);
        contributionChecker.run();
    }
}