import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

public class P131_PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), s, 0);
        return list;
    }

    // iteration is similar to subsets, each time considers a substring from start to i (as palindrome candidate)
    private static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
        if (start == s.length()) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < s.length(); i++) { // start -> i (check if palindromic), add-> recurse->backtrack, add templist to list when start == s.length()
                if (isPalindromic(s, start, i)) {
                    tempList.add(s.substring(start, i+1));
                    backtrack(list, tempList, s, i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    private static boolean isPalindromic(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] probs = {
            "aab",
            "a"
        };
        for (String prob: probs) {
            System.out.println(partition(prob));
        }
    }

    // a b c 
    // a bc
    // ab c , wont procceed with recursion call if ab is not palindromic
    // abc
}
