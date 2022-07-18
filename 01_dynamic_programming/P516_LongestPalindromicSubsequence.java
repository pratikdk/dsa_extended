public class P516_LongestPalindromicSubsequence {
    // 
    //
    // Build a dp matrix m x m, look for matches only in [i][i + >=1] 
    // if a match then set dp i,j to 2 + any previous internal max palindrome length
    // else set dp i,j to any previous internal max palindrome length
    //
    public static int longestPalindromicSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i+1; j < s.length(); ++j) { // absorb (subseq palindromes) or relay (other occurances)
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2; // current 2 letters + anything in between
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]); // self palindromes ("a") or relays (frm l and b)
                }
            }
        }
        return dp[0][s.length()-1];
    }
    
    public static void main(String[] args) {
        String[] probs = {
            "bbbab",
            "cbbd",
            "abdsaba"
        };
        for (String s: probs) {
            System.out.println(longestPalindromicSubseq(s));
        }
    }
}
