// import java.util.Map;
// import java.util.PriorityQueue;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;

// public class P451_SortCharactersByFrequency {

//     public static String frequencySort1(String s) {
//         Map<Character, Integer> frequencyMap = new HashMap<>();
//         for (char c: s.toCharArray()) {
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
//         }
//         List<Character>[] buckets = new List[s.length()+1];
//         for (char key: frequencyMap.keySet()) {
//             int frequency = frequencyMap.get(key);
//             if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
//             buckets[frequency].add(key);
//         }

//         StringBuilder sb = new StringBuilder();
//         for (int pos = buckets.length-1; pos >= 0; --pos) {
//             if (buckets[pos] != null) {
//                 for (char c: buckets[pos]) {
//                     for (int i = 0; i < pos; i++) {
//                         sb.append(c);
//                     }
//                 }
//             }   
//         }

//         return sb.toString();
//     }

//     public static String frequencySort2(String s) {
//         Map<Character, Integer> frequencyMap = new HashMap<>();
//         for (char c: s.toCharArray()) {
//             frequencyMap.put(c, frequencyMap.getOrDefault(c, 0)+1);
//         }

//         PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//         for (Map.Entry<Character, Integer> entry: frequencyMap.entrySet()) {
//             maxHeap.add(entry);
//         } // addAll();

//         StringBuilder sb = new StringBuilder();
//         while (!maxHeap.isEmpty()) {
//             Map.Entry<Character, Integer> entry = maxHeap.poll();
//             for (int i = 0; i < entry.getValue(); i++) {
//                 sb.append(entry.getKey());
//             }
//         }

//         return sb.toString();
//     }

//     public static void main(String[] args) {
//         String[] probs = {
//             "tree",
//             "cccaaa",
//             "Aabb"
//         };
//         for (String prob: probs){
//             //System.out.println(frequencySort1(prob));
//             System.out.println(frequencySort2(prob));
//         }
//     }
// }
