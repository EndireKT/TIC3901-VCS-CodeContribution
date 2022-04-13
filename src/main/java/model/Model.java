package model;

import model.projectFiles.CListGenerator;
import model.projectFiles.PathEncoder;
import model.projectFiles.ProjectInfo;
import model.projectFiles.RepoValidator;

import java.util.ArrayList;

public class Model {
    private ProjectInfo projectInfo;
    private static Model model = null;
    private String pathCode;
    private String remoteRepoGitUrl;
    private ArrayList<String> commitList;
    private ArrayList<String> authorList;

    private Model(){

    }

    public static Model getInstance(){
        if (model == null){
            model = new Model();
        }
        return model;
    }

    public void initiateContributionChecker(String userStartCommit, String filePath){

    }

    public ProjectInfo getProjectInfo(){
        return projectInfo;
    }

    public ArrayList<String> getListOfCommits() {

        return commitList;
    }

    public ArrayList<String> getListOfAuthors() {

        return authorList;
    }

    public void setPathCodeAndRemoteGitUrl(String filePath){
        pathCode = PathEncoder.getLocalPathInCode(filePath);
        remoteRepoGitUrl = PathEncoder.getGitRemoteProjectUrl(pathCode);
    }

    public Boolean isValidCommitAndAuthorList(){
        populateCommitandAuthorList();
        if (RepoValidator.isCommitExist(commitList) && RepoValidator.isCommitExist(commitList)) {
            return RepoValidator.isTwoListSizeEqual(commitList, authorList);
        }
        return false;
    }

    public Boolean isValidGitRepo() {
        return RepoValidator.isRemoteGitRepoExist(remoteRepoGitUrl);
    }

    public Boolean isValidCommit(String userStartCommit){
        // todo
        return null;
    }

    private void populateCommitandAuthorList(){
        commitList = CListGenerator.getCommitList(pathCode);
        authorList = CListGenerator.getAuthorList(pathCode);
    }
}
