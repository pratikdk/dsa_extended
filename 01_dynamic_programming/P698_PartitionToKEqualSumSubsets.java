import java.util.Arrays;
import java.util.Collections;

public class P698_PartitionToKEqualSumSubsets {

    public static boolean canPartitiionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if ((sum % k) != 0) {
            return false;
        }
        int targetSetSum = sum/k;

        Integer[] rNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(rNums, Collections.reverseOrder());

        boolean[] visited = new boolean[n];

        return canPartitiion(k, rNums, targetSetSum, visited, 0, 0);
    }

    public static boolean canPartitiion(int k, Integer[] nums, int targetSetSum, boolean[] visited, int currSetSum, int start) {
        if (k == 1)  // remaining elems in last set will always sum to targetSum
            return true; 
        if (currSetSum == targetSetSum) // curr subset complete, make more
            return canPartitiion(k-1, nums, targetSetSum, visited, 0, 0);  
        for (int i = start; i < nums.length; i++) {
            if ((!visited[i]) && (currSetSum + nums[i] <= targetSetSum)) {
                visited[i] = true;
                if (canPartitiion(k, nums, targetSetSum, visited, currSetSum + nums[i], i+1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{4,3,2,3,5,2,1}, {4}},
            {{1,2,3,4}, {3}}
        };
        for (int[][] prob: probs) {
            System.out.println(canPartitiionKSubsets(prob[0], prob[1][0]));
        }
    }
}
