package projectFile;

import contributionChecker.ContributionChecker;

public class ProjectFileInfo {

    // todo some private variables
    private ContributionChecker contributionChecker;

    public ProjectFileInfo(){
        // todo
        contributionChecker = new ContributionChecker();
    }

    public void run(){
        // todo create myFile objects

        // todo run ContributionChecker on each myFile
        contributionChecker.run();
    }


    public static void checkContribution(){

    }
}
