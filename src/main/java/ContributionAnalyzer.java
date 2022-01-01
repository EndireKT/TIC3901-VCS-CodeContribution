import projectFiles.Folder;
import storage.Storage;
import ui.Ui;

public class ContributionAnalyzer {

    // todo some private variables
    private Folder folder;
    private Ui ui;
    private Storage storage;

    public ContributionAnalyzer(){
        // todo
        folder = new Folder();
        storage = new Storage();
        ui = new Ui();
    }

    public void run(){

        // todo call storage
        storage.run();

        // todo call Ui
        String projectDirectory = ui.getProjectPath();

        // todo pass storage stuffs to ProjectFileInfo
        folder.run(projectDirectory);
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
