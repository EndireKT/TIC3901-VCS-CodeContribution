package contributionChecker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ProjectContributorEvaluatorTest {

    @Test
    void evaluateFileContributionFrequency() {
        ArrayList<String> contributors = new ArrayList<>();
        contributors.add("aaa");
        contributors.add("aaa");
        contributors.add("bbb");
        contributors.add("bbb");
        contributors.add("aaa");
        contributors.add("ccc");

        Set<String> contributorFrequency = new HashSet<>(contributors);
        for (String contributorName : contributorFrequency) {
            System.out.println(contributorName + ": " + Collections.frequency(contributors, contributorName));
        }
    }


    @Test
    void evaluateProjectContributor() {
        ArrayList<String> contributors = new ArrayList<>();
        contributors.add("aaa");
        contributors.add("aaa");
        contributors.add("bbb");
        contributors.add("bbb");
        contributors.add("bbb");
        contributors.add("aaa");
        contributors.add("ccc");

        Set<String> contributorFrequency = new HashSet<>(contributors);
        int maxFreq = 0;
        for (String contributorName : contributorFrequency) {
            int freq = Collections.frequency(contributors, contributorName);
            if (maxFreq < freq) {
                maxFreq = freq;
            }
        }
        System.out.println(maxFreq);

        ArrayList<String> names = new ArrayList<>();
        for (String contributorName : contributorFrequency) {
            int freq = Collections.frequency(contributors, contributorName);
            if (freq == maxFreq){
                names.add(contributorName);
                System.out.println(contributorName);
            }
        }
    }
}