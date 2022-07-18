// https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines
public class P242_ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int[] map = new int[128];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int counter = t.length();
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)]-- > 0) { counter--; }
            else {
                return false;
            }
        }
        return counter > 0 ? false : true;
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"anagram", "nagaram"},
            {"rat", "car"},
            {"doll", "ldol"},
            {"xfce!", "ec!fx"},
            {"1", "2"},
            {"ab", "a"},
            {"a", "ab"}
        };

        for (String[] prob: probs) {
            System.out.println(isAnagram(prob[0], prob[1]));
            // System.out.println(isAnagram2(prob[0], prob[1]));
        }
    }

    // public static boolean isAnagram2(String s, String t) {
    //     int[] map = new int[128];
    //     for (char c: t.toCharArray()) {
    //         map[c] += 1;
    //     }
    //     int counter = t.length();
    //     int end = 0;

    //     while (end < s.length()) {
    //         if (map[s.charAt(end++)]-- > 0) counter--;
    //         else {
    //             return false;
    //         } 
    //     }

    //     return counter == 0;
    // }
}
