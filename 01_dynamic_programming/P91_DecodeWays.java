import java.util.Arrays;

// https://leetcode.com/problems/decode-ways/discuss/30451/Evolve-from-recursion-to-dp

public class P91_DecodeWays {

    // Recursive
    public static int numDecodings_recur(String s) {
        if (s.length() == 0) return 0;
        return numDecodings_recur(s, 0);
    }
    public static int numDecodings_recur(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        int res = numDecodings_recur(s, i+1);
        if (i < s.length()-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
            res += numDecodings_recur(s, i+2);
        }
        return res;
    }

    // Recursive, dp
    public static int numDecodings_recur2(String s) {
        int n = s.length();
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[n] = 1;
        return numDecodings_recur2(s, 0, dp);
    }
    
    // sol with correct condition
    // public static int numDecodings_recur2(String s, int i, int[] dp) {
    //     if (dp[i] > -1) return dp[i]; // if (i == s.length()) return dp[i];
    //     if (s.charAt(i) == '0') return dp[i] = 0;
    //     dp[i] = numDecodings_recur2(s, i+1, dp);
    //     if (i < s.length()-1 && ((s.charAt(i) == '1' || s.charAt(i) == '2') && s.charAt(i+1) < '7')) { // correction
    //         dp[i] += numDecodings_recur2(s, i+2, dp);
    //     }
    //     return dp[i];
    // }

    public static int numDecodings_recur2(String s, int i, int[] dp) {
        int n = s.length();
        if (dp[i] > -1) return dp[i];
        if (s.charAt(i) == '0') return dp[i] = 0;
        dp[i] = numDecodings_recur2(s, i+1, dp);
        if (i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
            dp[i] += numDecodings_recur2(s, i+2, dp);
        }
        return dp[i];
    }

    // Iterative, dp // reverse scan
    public static int numDecodings_iter(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i+1];
                if (i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
                    dp[i] += dp[i+2];
                }
            }
        }
        return dp[0];
    }

    // Iterative, dp, constant space
    public static int numDecodings_iter2(String s) {
        int n = s.length();
        int dp1 = 1, dp2 = 0;
        for (int i = n-1; i >= 0; i--) {
            int dp = (s.charAt(i) == '0') ? 0 : dp1;
            if (i < n-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i+1) < '7')) {
                dp += dp2;
            }
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }

    public static void main(String[] args) {
        String[] probs = {
            "12",
            "226",
            "0",
            "106",
            "2611055971756562",
            "26105"
        };
        for (String s: probs) {
            System.out.println(numDecodings_recur(s));
        }
    }
}


// 1 1 1 0 6