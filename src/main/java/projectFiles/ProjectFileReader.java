package projectFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ProjectFileReader {

    public static String readFile(File file) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
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
