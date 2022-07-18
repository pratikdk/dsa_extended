import java.util.Arrays;

// fewest number of coins to make up the amount

public class P322_CoinChange {
    // https://leetcode.com/problems/coin-change/discuss/77360/C%2B%2B-O(n*amount)-time-O(amount)-space-DP-solution
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1]; // initialized with amount+1, because we are minimizing
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) { // choose coins that are <= i
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1); // add +1 for a valid coin j 
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{1,2,5}, {11}},
            {{2}, {3}},
            {{1}, {0}},
            {{1}, {1}},
            {{1}, {2}},
            {{1}, {11}}
        };
        for (int[][] prob: probs) {
            System.out.println(coinChange(prob[0], prob[1][0]));
        }
    }
}
