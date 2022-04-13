package model.contributionChecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import model.fileInfo.FileInfo;

public class ProjectContributorEvaluator {

    private ArrayList<FileInfo> filesInfos;
    private ArrayList<String> projectContributors;
    private Set<String> contributorFrequency;
    private ArrayList<String> projectMainContributors;

    public ProjectContributorEvaluator(ArrayList<FileInfo> filesInfos) {
        this.filesInfos = filesInfos;
        projectContributors = new ArrayList<>();
        projectMainContributors = new ArrayList<>();
    }

    public void evaluate() {
        if (filesInfos.isEmpty()) {
            return;
        }

        for (FileInfo fileInfo : filesInfos) {
            projectContributors.add(fileInfo.getMainContributor());
        }

        contributorFrequency = new HashSet<>(projectContributors);

        int maxFreq = 0;
        for (String contributorName : contributorFrequency) {
            int freq = Collections.frequency(projectContributors, contributorName);
            if (maxFreq < freq) {
                maxFreq = freq;
            }
        }

        for (String contributorName : contributorFrequency) {
            int freq = Collections.frequency(projectContributors, contributorName);
            if (freq == maxFreq) {
                projectMainContributors.add(contributorName);
            }
        }
    }

    public Set<String> getContributorFrequency() {
        return contributorFrequency;
    }

    public ArrayList<String> getProjectMainContributors() {
        return projectMainContributors;
    }
}
