package model;

import model.projectFiles.ProjectInfo;

import java.util.ArrayList;

public class Model {
    private ProjectInfo projectInfo;

    public Model(){

    }

    public void initiateContributionChecker(String userStartCommit, String filePath){

    }

    public ProjectInfo getProjectInfo(){
        return projectInfo;
    }

    public ArrayList<String> getListOfCommits() {
        // todo
        return null;
    }

    public ArrayList<String> getListOfAuthors() {
        // todo
        return null;
    }

    public Boolean isValidCommitAndAuthorList(){
        // todo
        return null;
    }

    public Boolean isValidGitRepo() {
        // todo
        return null;
    }

    public Boolean isValidCommit(String userStartCommit){
        // todo
        return null;
    }

}
