public class P844_BackspaceStringCompare {

    public static boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int countS = 0;
        int countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || s.charAt(i) == '#')) { // reduce or increase count; stop at a valid char
                if (s.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            while (j >= 0 && (countT > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char left = (i < 0) ? '#' : s.charAt(i); // extract valid char to compare
            char right = (j < 0) ? '#' : t.charAt(j); // valid char to comapre
            if (left != right) return false;
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] probs = {
            {"ab#c", "ad#c"},
            {"ab##", "c#d#"},
            {"a#c", "b"}
        };
        for (String[] prob: probs) {
            System.out.println(backspaceCompare(prob[0], prob[1]));
        }
    }
}