public class P159_LongestSubstringWithAtMost2DistinctChar {
    public static int longestSubstring(String s) {
        int[] map = new int[128];
        int counter = 0;
        int start = 0, end = 0;
        int wSize = 0;
        while (end < s.length()) {
            if (map[s.charAt(end++)]++ == 0) { counter++; }
            while (counter > 2) {
                if (map[s.charAt(start++)]-- == 1) { counter--; }
            }
            wSize = Math.max(wSize, end-start);
        }
        return wSize;
    }
    public static void main(String[] args) {
        String[] probs = {
            "daaabbbc",
            "abcd",
            "aaaab",
            "aaabc"
        };
        for (String s: probs) {
            System.out.println(longestSubstring(s));
            // System.out.println(longestSubStrKDistinct(s));
        }
    }

    // =============================
    // public static int longestSubStrKDistinct(String s) {
    //     int start = 0, end = 0;
    //     int maxSize = 0;
    //     int[] map = new int[128];
    //     int counter = 0;
    //     while (end < s.length()) {
    //         if (map[s.charAt(end++)]++ == 0) counter++;
    //         while (counter > 2) {
    //             if (map[s.charAt(start++)]-- == 1) counter--;
    //         }
    //         maxSize = Math.max(maxSize, end-start);
    //     }
    //     return maxSize;
    // }
}
