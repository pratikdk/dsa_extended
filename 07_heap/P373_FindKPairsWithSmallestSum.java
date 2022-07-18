import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P373_FindKPairsWithSmallestSum {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 || nums2.length==0 || k==0) return new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]+a[1]) - (b[0]+b[1]));

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.add(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            res.add(new ArrayList<>(Arrays.asList(curr[0], curr[1])));
            if (curr[2] == nums2.length-1) continue;
            minHeap.add(new int[]{curr[0], nums2[curr[2]+1], curr[2]+1});
        }

        return res;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{1,7,11}, {2,4,6}, {3}},
            {{1,1,2}, {1,2,3}, {2}},
            {{1,2}, {3}, {3}}
        };
        for (int[][] prob: probs) {
            System.out.println(kSmallestPairs(prob[0], prob[1], prob[2][0]));
        }
    }
}