package contributionChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContributionCheckerTest {

    @Test
    boolean compareContribution(String fileContentPreviousCommit, String fileContentCurrentCommit) {
        return LevenshteinDistance.compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
    }

    @DisplayName("Test 1, File A, commit 1 vs commit 2")
    @Test
    void compareContribution1(){
        String fileContentPreviousCommit = "public class fileA {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        String fileContentCurrentCommit = "public class fileA {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "        String HW = 'Hello World\";\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "    }\n" +
                "}";
        boolean result = compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
        assertEquals(true, result);
        showResult(result);
    }

    @DisplayName("Test 2, File A, commit 2 vs commit 3")
    @Test
    void compareContribution2(){
        String fileContentPreviousCommit = "public class fileA {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "        String HW = 'Hello World\";\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "    }\n" +
                "}";

        String fileContentCurrentCommit = "public class fileA {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "        String HW = 'Hello World\";\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "        System.out.println(HW);\n" +
                "\n" +
                "    }\n" +
                "}\n";

        boolean result = compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
        assertEquals(true, result);
        showResult(result);
    }

    @DisplayName("Test 3, File B, commit 1 vs commit 2")
    @Test
    void compareContribution3(){
        String fileContentPreviousCommit = "public class fileB {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        String fileContentCurrentCommit = "public class fileB {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n";

        boolean result = compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
        assertEquals(false, result);
        showResult(result);
    }

    @DisplayName("Test 4, File B, commit 2 vs commit 3")
    @Test
    void compareContribution4(){
        String fileContentPreviousCommit = "public class fileB {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}";

        String fileContentCurrentCommit = "public class fileB {\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "    }\n" +
                "}\n";

        boolean result = compareContribution(fileContentPreviousCommit, fileContentCurrentCommit);
        assertEquals(false, result);
        showResult(result);
    }

    @Test
    void compareFileMainContributor() {
    }

    static void showResult(boolean result){
        if (result) {
            System.out.println("New main contributor is: current commit\n");
        } else {
            System.out.println("New main contributor is: previous commit\n");
        }
    }
}