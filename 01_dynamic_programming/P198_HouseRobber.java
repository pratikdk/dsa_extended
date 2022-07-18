public class P198_HouseRobber {

    public static int rob(int[] nums) {
        // RR: dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) { // if nums.len == 4, then i is 1 2 3, we set dp for nums.len-1
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]); // nums[i-1], because dp has extra 0th index
        }
        return dp[nums.length]; // final element
    }

    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {  // nums.length+1 == dp.length
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]); // dp[i] = dp[i-1] or (d[i-2]+curr)
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3,1},
            {2,7,9,3,1},
            {0,2}
        };

        for (int[] prob: probs) {
            System.out.println(rob2(prob));
        }
    }
}
