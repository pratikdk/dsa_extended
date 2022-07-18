import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {
    public static Integer[] topKFrequent1(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length+1];

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        for (int key: frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for (int pos = buckets.length-1; pos >= 0 && res.size() < k; pos--) {
            if (buckets[pos] != null) {
                res.addAll(buckets[pos]);
            }
        }
        
        return res.subList(0, k).toArray(new Integer[0]);
    }


    public static Integer[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num: nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue(); // Decreasing order, max -> min
            }
        }); // (a, b) -> b.getValue() - a.getValue()

        for (Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }

        return res.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        int[][][] probs = { 
            {{1,1,1,2,2,3}, {2}},
            {{1}, {1}}
        };
        for (int[][] prob: probs) {
            //System.out.println(Arrays.toString(topKFrequent1(prob[0], prob[1][0])));
            System.out.println(Arrays.toString(topKFrequent2(prob[0], prob[1][0])));
        }
    }
}
