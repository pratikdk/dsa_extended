import java.util.Arrays;

public class P300_LongestIncreasingSubsequence {

    public static int lengthOfLIS_sol1(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) i = -(i + 1); // [i-1] < x <= [i], place x(i.e num) at i, its imaginary location
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }

    public static int lengthOfLIS_sol2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num: nums) {
            int i = 0, j = len;
            while (i < j) { // binary search
                int mid = (i + j) / 2;
                if (dp[mid] < num) {
                    i = mid+1;
                } else {
                    j = mid;
                }
            }
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {10,9,2,5,3,7,101,18},
            {0,1,0,3,2,3},
            {7,7,7,7,7,7,7}
        };
        for (int[] prob: probs) {
            // System.out.println(lengthOfLIS_sol1(prob));
            System.out.println(lengthOfLIS_sol2(prob));
        }
    }
}
