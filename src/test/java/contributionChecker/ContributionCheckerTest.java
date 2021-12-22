package contributionChecker;

import org.junit.jupiter.api.Test;
import projectFile.FileToBeChecked;

import static org.junit.jupiter.api.Assertions.*;

class ContributionCheckerTest {

    @Test
    void run_unitrun() {
        FileToBeChecked fileToBeChecked = new FileToBeChecked();
        ContributionChecker contributionChecker = new ContributionChecker(fileToBeChecked);
        contributionChecker.run();
    }
}