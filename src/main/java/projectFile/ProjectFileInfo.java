package projectFile;

import contributionChecker.ContributionChecker;

public class ProjectFileInfo {

    // todo some private variables
    private ContributionChecker contributionChecker;
    private FileToBeChecked fileToBeChecked;

    public ProjectFileInfo(){
        // todo
        // dummy fileToBeChecked
        fileToBeChecked = new FileToBeChecked();
        contributionChecker = new ContributionChecker(fileToBeChecked);
    }

    public void run(){
        // todo create myFile objects

        // todo run ContributionChecker on each myFile
        contributionChecker.run();
    }

    public static void checkContribution(){

    }
}
