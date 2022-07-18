import java.util.Arrays;

public class P1092_ShortestCommonSuperSequence {

    public static String shortestCommonSupersequence(String str1, String str2) {
        String res = "";
        int i = 0, j = 0;
        for (char c: lcs(str1, str2).toCharArray()) {
            while (str1.charAt(i) != c) {
                res += str1.charAt(i++);
            }
            while (str2.charAt(j) != c) {
                res += str2.charAt(j++);
            }
            res += c;
            i++;
            j++;
        }
        return res + str1.substring(i, str1.length()) + str2.substring(j, str2.length());
    }

    // Utility function: longest common subsequence 
    public static String lcs(String text1, String text2) {
        String[][] dp = new String[text1.length()+1][text2.length()+1];
        for (String[] row: dp) Arrays.fill(row, "");
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) { // if char at i == j ? +1
                    dp[i][j] = dp[i-1][j-1] + text1.charAt(i-1);
                } else { // if not max(left, top) cells
                    dp[i][j] = dp[i][j-1].length() > dp[i-1][j].length() ? dp[i][j-1] : dp[i-1][j];
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"abac", "cab"},
            {"aaaa", "aaaa"},
            {"abc", "def"}
        };
        for (String[] prob: probs) {
            System.out.println(shortestCommonSupersequence(prob[0], prob[1]));
        }
    }
}


// Find LCS between strings, Iterate on LCS characters, run a while loop on both strings each.. coping chars until current lcs char is found, append lcs char to res, finally append leftover characterd from str1 and str2 to res. 