import java.io.File;
import java.io.FileNotFoundException;
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

    public static void PrintFile(File pFile) {
        Scanner s;
        try {
            s = new Scanner(pFile);
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void ReadFile() {
        String FileName = GetFileName();
        File newFile = OpenFile(FileName);
        PrintFile(newFile);
    }
}
