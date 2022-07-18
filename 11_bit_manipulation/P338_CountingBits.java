import java.util.Arrays;

public class P338_CountingBits {

    public static int[] countBits(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            // shift right by 1 bit get dp value for shifted number, and check if lost is 1
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] probs = {2, 5};
        for (int prob: probs) {
            System.out.println(Arrays.toString(countBits(prob)));
        }
    }
}
