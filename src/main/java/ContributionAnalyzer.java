import projectFile.ProjectFileInfo;
import storage.Storage;
import ui.Ui;

public class ContributionAnalyzer {

    // todo some private variables
    private ProjectFileInfo projectFileInfo;
    private Ui ui;
    private Storage storage;

    public ContributionAnalyzer(){
        // todo
        projectFileInfo = new ProjectFileInfo();
        storage = new Storage();
        ui = new Ui();
    }

    public void run(){

        // todo call storage
        storage.run();

        // todo call Ui
        ui.run();

        // todo pass storage stuffs to ProjectFileInfo
        projectFileInfo.run();
    }

    public static void main (String[] args){
        System.out.println("WELCOME TO CONTRIBUTION ANALYZER");
        System.out.println("WELCOME TO CONTRIBUTION ANALYZER");
        System.out.println("WELCOME TO CONTRIBUTION ANALYZER");
        System.out.println("(say 3 times because it is important)\n\n\n");

        ContributionAnalyzer contributionChecker = new ContributionAnalyzer();
        contributionChecker.run();
    }
}
