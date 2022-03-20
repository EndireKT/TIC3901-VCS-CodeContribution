package fileInfo;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

public class JavaFileReader {

    public static String readFile(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            java.io.FileReader fr = new java.io.FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines.toString();
    }
}
