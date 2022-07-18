import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139_WordBreak {

    // recursive // refer sol3
    public static boolean wordBreak_sol1(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return wb(s, dict);
    }

    private static boolean wb(String s, Set<String> dict) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (dict.contains(s.substring(0, i)) && wb(s.substring(i), dict)) {
                return true;
            }
        }
        return false;
    }


    // Iterative
    public static boolean wordBreak_sol2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true; 
                    break; // since we have a substring from j to i, no point in validating further
                }
            }
        }
        return dp[s.length()];
    }


    // refined ver of sol1
    public static boolean wordBreak_sol3(String s, List<String> wordList) {
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if (wordList.contains(s.substring(0, i+1)) && wordBreak_sol3(s.substring(i+1), wordList)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String[][][] probs = {
            {{"leetcode"}, {"leet","code"}},
            {{"leetcode"}, {"leet","leetc","ode"}},
            {{"applepenapple"}, {"apple","pen"}},
            {{"catsandog"}, {"cats","dog","sand","and","cat"}},
            {{"abcd"}, {"a", "b", "c", "bc", "ab", "abc"}},
            {{"abcd"}, {"a", "b", "c", "d", "ab"}},
            {{"abcdef"}, {"a", "abc", "def"}}
        };
        for (String[][] prob: probs) {
            // System.out.println(wordBreak_sol1(prob[0][0], Arrays.asList(prob[1])));
            // System.out.println(wordBreak_sol2(prob[0][0], Arrays.asList(prob[1])));
            System.out.println(wordBreak_sol2(prob[0][0], Arrays.asList(prob[1])));
        }
    }
}
