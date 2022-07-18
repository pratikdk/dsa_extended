import java.util.Collections;

public class P424_LongestRepeatingCharacterReplacement {
    
    // this algo isn't correct, try input {aaabcd, 2}, the while loop considers aabcd as valid, 
    public static int characterReplacement(String s, int k) { 
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxcount = 0, maxlength = 0;
        for (int end = 0; end < len; end++) {
            maxcount = Math.max(maxcount, ++count[s.charAt(end) - 'A']); // increase char count at i
            while (end-start+1 - maxcount > k) { // if > number of non repeating chars. [increasing maxcount entertained.]
                count[s.charAt(start) - 'A']--; // shift window to left by one index
                start++;
            }
            maxlength = Math.max(maxlength, end-start+1); // record maxlength of window
        }
        return maxlength;
    }


    public static int longestStringWithChrReplacement(String s, int k) {
        int[] map = new int[26];
        int maxWindowSize = 0;
        int l = 0, r = 0;
        
        //maxf = 0
        while (r < s.length()) {
            map[s.charAt(r) - 'A']++;
            r++;
            // maxf = max(maxf, map[current_char])

            while ((r-l - maxInArray(map)) > k) { // formula: currentwindowSize - maxFreq(max occuring character count) <= k; or use maxf
                // left shift/slide
                map[s.charAt(l) - 'A']--;
                l++;
            }

            maxWindowSize = Math.max(maxWindowSize, r-l);
        }

        return maxWindowSize;
    }

    public static int maxInArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int x: arr) {
            max = Math.max(max, x);
        }
        return (max == Integer.MIN_VALUE) ? -1 : max;
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"ABAB", "2"},
            {"ABCDA", "2"},
            {"AABABBA", "1"},
            {"AAABCD", "2"}
        };
        for (String[] prob: probs) {
            System.out.println(characterReplacement(prob[0], Integer.parseInt(prob[1])));
            // System.out.println(longestStringWithChrReplacement(prob[0], Integer.parseInt(prob[1])));
        }
    }
}