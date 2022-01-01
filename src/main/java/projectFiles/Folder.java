package projectFiles;

import contributionChecker.ContributionChecker;

import java.util.ArrayList;

public class Folder {

    private ArrayList<FileInfo> files;

    public Folder(){
    }

    public void run(String projectDirectory){

        files = FileIdentifier.getJavaFilesFromPath(projectDirectory);

        for (FileInfo fileInfo: files){
            ContributionChecker contributionChecker = new ContributionChecker(fileInfo);
        }
    }

    // todo check contribution here?
    public static void checkContribution(){

    }
}
