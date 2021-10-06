import java.io.File;
import java.util.Scanner;

public class FileController {

    public static String GetFileName() {
        System.out.println("Please input txt file name:");
        Scanner in = new Scanner(System.in);
        String FileName = in.nextLine() + ".txt";
        return FileName;
    }
    
    public static File OpenFile(String FileName) {
        File newFile = null;
        try {
            newFile = new File(FileName);
        } catch (NullPointerException e) {
            System.out.println("File not found");
        }
        return newFile;
    }

}
