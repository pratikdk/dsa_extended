public class P1143_LongestCommonSubsequence {

    public static int longestCommonSubsequence_sol1(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) { // if char at i == j ? +1
                    dp[i][j] = dp[i-1][j-1] + 1; // any common matches previously and within
                } else { // if not max(left, top) cells
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]); // relay
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    // public static int longestCommonSubsequence_sol2(String text1, String text2) {
    //     int[] dp = new int[text2.length()+1];
    //     int dpLeft = 0;
    //     for (int i = 1; i <= text1.length(); i++) {
    //         for (int j = 1; j <= text2.length(); j++) {
    //             if (text1.charAt(i-1) == text2.charAt(j-1)) { // if char at i == j ? +1
    //                 dp[j] = dp[j-1] + 1;
    //             } else { // if not max(left, top) cells
    //                 dp[j] = Math.max(dpLeft, dp[j]);
    //             }
    //             dpLeft = Math.max(dpLeft, dp[j]);
    //         }
    //         dpLeft = 0;
    //     }
    //     return dp[text2.length()];
    // }

    public static void main(String[] args) {
        String[][] probs = {
            {"abcde", "ace"},
            {"abc", "abc"},
            {"acb", "abc"},
            {"abc", "def"}
        };
        for (String[] prob: probs) {
            System.out.println(longestCommonSubsequence_sol1(prob[0], prob[1]));
            // System.out.println(longestCommonSubsequence_sol2(prob[0], prob[1]));
        }
    }
}
