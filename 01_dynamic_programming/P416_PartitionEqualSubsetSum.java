public class P416_PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if ((sum & 1) == 1) { // val + val = sum, an odd val can't be equally divided
            return false;
        }
        sum /= 2;

        boolean[][] dp = new boolean[n+1][sum+1]; // i: num[i], j: sum[j]; 0 indexed
        dp[0][0] = true; // empty set == 0(j == 0)
        for (int i = 1; i < n+1; i++) { // of all the possible subsets from 0->i, an empty == 0(j == 0)
            dp[i][0] = true;
        }

        // x + y .. = sum, hence find element(s) that can satisfy value(x, y), when having incomplete sum
        // search i-1(row) for x-elem[i](required val), if any previous elem satisfies x we pass it(t/f) down,
        // finallly we look at sum(jth column) and final row to see t/f got passed down.
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j]) || (dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,5,11,5},
            {1,2,3,5}
        };
        for (int[] prob: probs) {
            System.out.println(canPartition(prob));
        }
    }
}