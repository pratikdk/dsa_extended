import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49_GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) { return new ArrayList<>(); }
        
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyString = String.valueOf(c);
            if (!map.containsKey(keyString)) {map.put(keyString, new ArrayList<>());} // putIfAbsent() 
            map.get(keyString).add(s); //  put(keyString, getOrDefault(keystring, default).add())
        }

        return new ArrayList<>(map.values()); // return a copy
    }
    public static void main(String[] args) {
        String[][] probs = {
            {"eat","tea","tan","ate","nat","bat"},
            {""},
            {"a"}
        };
        for (String[] prob: probs) {
            System.out.println(groupAnagrams(prob));
        }
    }
}
