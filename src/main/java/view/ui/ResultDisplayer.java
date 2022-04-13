package view.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import model.fileInfo.FileInfo;
import model.projectFiles.ProjectInfo;

public class ResultDisplayer {

    private ProjectInfo projectInfo;

    public ResultDisplayer(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    public void printIndividualFileContributor() {
        ArrayList<FileInfo> fileInfos_CurrentCommit = projectInfo.getFileInfos_CurrentCommit();
        if (fileInfos_CurrentCommit.isEmpty()) {
            System.out.println("No files are found in Java directory.");
        } else {
            System.out.println("Individual File Contributors:");
            for (FileInfo fileInfo : fileInfos_CurrentCommit) {
                System.out.println(fileInfo.getFilePath());
                System.out.println("File contributor: " + fileInfo.getMainContributor());
            }
            System.out.println("=============================================");
        }
    }

    public void printContributorFrequency() {
        ArrayList<String> projectContributors = new ArrayList<>();

        for (FileInfo fileInfo : projectInfo.getFileInfos_CurrentCommit()) {
            projectContributors.add(fileInfo.getMainContributor());
        }

        Set<String> contributorFrequency = projectInfo.getContributorFrequency();
        if (contributorFrequency.isEmpty()){
            System.out.println("No contributor are found in the project");
        } else {
            System.out.println("File Contributors Frequency:");
            for (String contributorName : contributorFrequency){
                System.out.println(contributorName + " : " + Collections.frequency(projectContributors, contributorName));
            }
            System.out.println("=============================================");
        }
    }

    public void printProjectMainContributors() {
        ArrayList<String> projectMainContributors = projectInfo.getProjectMainContributors();
        if (projectMainContributors.isEmpty()){
            return;
        } else {
            System.out.println("Project Main Contributors are:");
            System.out.println(projectMainContributors);
            System.out.println("=============================================");
        }

    }
}
