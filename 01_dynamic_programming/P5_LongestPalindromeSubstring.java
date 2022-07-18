public class P5_LongestPalindromeSubstring {
    int lo, maxLen;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }

    private void extendPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        if (maxLen < r-l-1) {
            lo = l+1;
            maxLen = r-l-1;
        }
    }

    public static void main(String[] args) {
        P5_LongestPalindromeSubstring pc;
        String[] probs = {
            "babad",
            "cbbd"
        };
        for (String prob: probs) {
            pc = new P5_LongestPalindromeSubstring();
            System.out.println(pc.longestPalindrome(prob));
        }
    }
}
