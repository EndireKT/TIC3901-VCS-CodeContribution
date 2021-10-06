import java.util.Scanner;

public class FileController {

    public static String GetFileName() {
        System.out.println("Please input txt file name:");
        Scanner in = new Scanner(System.in);
        String FileName = in.nextLine() + ".txt";
        return FileName;
    }
    
}
