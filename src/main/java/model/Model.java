package model;

import model.projectFiles.CListGenerator;
import model.projectFiles.PathEncoder;
import model.projectFiles.ProjectInfo;
import model.projectFiles.RepoValidator;

import java.util.ArrayList;

public class Model {
    private ProjectInfo projectInfo;
    private static Model model = null;
    private String directoryPath;
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

    public void initiateContributionChecker(String userStartCommit){
        projectInfo = new ProjectInfo(directoryPath, pathCode, commitList, authorList, userStartCommit);
        projectInfo.getProjectInfo();
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

    public void setPathCodeAndRemoteGitUrl(String directoryPath){
        this.directoryPath = directoryPath;
        pathCode = PathEncoder.getLocalPathInCode(directoryPath);
        remoteRepoGitUrl = PathEncoder.getGitRemoteProjectUrl(pathCode);
    }

    public Boolean isValidCommitAndAuthorList(){
        populateCommitAndAuthorList();
        if (RepoValidator.isCommitExist(commitList) && RepoValidator.isCommitExist(commitList)) {
            return RepoValidator.isTwoListSizeEqual(commitList, authorList);
        }
        return false;
    }

    public Boolean isValidGitRepo() {
        return RepoValidator.isRemoteGitRepoExist(remoteRepoGitUrl);
    }

    public Boolean isValidCommit(String userStartCommit){
        for (String commit : commitList){
            if (userStartCommit.equals(commit)){
                return true;
            }
        }
        return false;
    }

    private void populateCommitAndAuthorList(){
        commitList = CListGenerator.getCommitList(pathCode);
        authorList = CListGenerator.getAuthorList(pathCode);
    }
}
