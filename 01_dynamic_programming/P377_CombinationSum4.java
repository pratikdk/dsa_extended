import java.util.Arrays;

/********* It is Permutation Sum, not Combination Sum *********/ 
/**************************************************************/
// (with duplicates)

public class P377_CombinationSum4 {
    // always start iteration from 0, and on each i reduce target(by i) and recurse
    // recursive // top down
    public static int combinationSum4_sol1(int[] nums, int target) {
        if (target == 0) return 1;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) { // start loop from 0 everytime // hence allow duplicates
            if (nums[i] <= target) {
                res += combinationSum4_sol1(nums, target-nums[i]);
            }
        }
        return res;
    }

    // recursive + dp // top down
    public static int combinationSum4_sol2(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return cm4_s2(nums, target, dp);
    }

    private static int cm4_s2(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) { // used when target == 0 or dp[target] != -1
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= target) {
                res += combinationSum4_sol1(nums, target-nums[i]);
            }
        }
        dp[target] = res;
        return dp[target];
    }

    public static int combinationSum4_sol3(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) { // i remaining to reach target
            for (int j = 0; j < nums.length; j++) { // target is i away, try every num in nums;
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]]; // relay 1 from dp, dp[i]; number or permutation for target i
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{1, 2, 3}, {4}},
            {{9}, {3}},
            {{2,3,6,7}, {7}}
        };
        for (int[][] prob: probs) {
            // System.out.println(combinationSum4_sol1(prob[0], prob[1][0]));
            // System.out.println(combinationSum4_sol2(prob[0], prob[1][0]));
            System.out.println(combinationSum4_sol3(prob[0], prob[1][0]));
        }
    }
}
