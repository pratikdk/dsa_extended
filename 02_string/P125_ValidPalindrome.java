public class P125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l <= r) { // skip everything until you find first valid char at l then r, once you have letters at l and r both, compare them.
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[] probs = {
            "pP",
            "A man, a plan, a canal: Panama",
            "racecar",
            "race a car",
            " "
        };
        for (String s: probs) {
            System.out.println(isPalindrome(s));
        }
    }
}
