package contributionChecker;

import java.util.Arrays;

public class LevenshteinDistance {

    /**
     * Compare two String using Levenshtein Distance
     *
     * Compute using the formula:
     *      if (LD value > half of total character size in str1 (previous commit))
     *
     * Return true if  LD value is greater
     * Return false if LD value is same or lower
     * 
     * @param str1 String representing the original text (in previous commit)
     * @param str2 String representing the edited text (in current commit)
     * @return boolean
     */
    public static boolean compareContribution(String str1, String str2) {
        int charStr2 = str2.length();
        int levenshtein_distance = compute_Levenshtein_distanceDP(str1, str2);

        if (levenshtein_distance > charStr2 / 2) {
            return true;
        } else {
            return false;
        }
    }

    private static int compute_Levenshtein_distanceDP(String str1, String str2) {

        // A 2-D matrix to store previously calculated
        // answers of subproblems in order
        // to obtain the final

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                // If str1 is empty, all characters of
                // str2 are inserted into str1, which is of
                // the only possible method of conversion
                // with minimum operations.
                if (i == 0) {
                    dp[i][j] = j;
                }

                // If str2 is empty, all characters of str1
                // are removed, which is the only possible
                //  method of conversion with minimum
                //  operations.
                else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    // find the minimum among three
                    // operations below


                    dp[i][j] = minmEdits(dp[i - 1][j - 1]
                                    + NumOfReplacement(str1.charAt(i - 1), str2.charAt(j - 1)), // replace
                            dp[i - 1][j] + 1, // delete
                            dp[i][j - 1] + 1); // insert
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }

    // check for distinct characters
    // in str1 and str2

    private static int NumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    // receives the count of different
    // operations performed and returns the
    // minimum value among them.

    private static int minmEdits(int... nums) {
        return Arrays.stream(nums).min().orElse(
                Integer.MAX_VALUE);
    }
}
