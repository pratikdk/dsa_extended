public class P309_BestTimetoBuySellSTockWithCooldown {
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75928/Share-my-DP-solution-(By-State-Machine-Thinking)

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices.length <= 1) {return 0;}
        int[] s0 = new int[n]; // state 0, i-2 vs i-1 profit, max
        int[] s1 = new int[n]; // state 1, don't buy vs buy, max
        int[] s2 = new int[n]; // state 2, ith(current) profit
        // for price at 0th index, three states are possible
        s0[0] = 0; // intial profit
        s1[0] = -prices[0]; // buy
        s2[0] = Integer.MIN_VALUE; // previous profit
        for (int i = 1; i < prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
            s2[i] = s1[i-1] + prices[i];
        }
        return Math.max(s0[n-1], s2[n-1]); // compare two final profits, max
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3,0,2},
            {1}
        };
        for (int[] prob: probs) {
            System.out.println(maxProfit(prob));
        }
    }
}
