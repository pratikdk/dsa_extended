public class P647_PalindromeSubstrings {
    private int count;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }

        return count;
    }

    private void extendPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--; 
            r++;
            count++;
        }
    }
    
    public static void main(String[] args) {
        P647_PalindromeSubstrings pc;
        String[] probs = {
            "abc",
            "aaa"
        };
        for (String prob: probs) {
            pc = new P647_PalindromeSubstrings();
            System.out.println(pc.countSubstrings(prob));
        }
    }
}
