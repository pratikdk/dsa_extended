public class P70_ClimbingStairs {
    // Similar to fibonacci number
    // Similar probs:
    // 91. Decode Ways
    // 62. Unique Paths
    // 509. Fibonacci Number

    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int oneStepBefore = 2; // ways to climb 2 stairs // i-1 
        int twoStepsBefore = 1; // ways to climb 1 stair // i-2
        int all_ways = 0;
        for (int i = 3; i <= n; i++) {
            all_ways = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = all_ways;
        }
        return all_ways;
    }

    public static void main(String[] args) {
        int[] probs = {
            2,
            3
        };
        for (int n: probs) {
            System.out.println(climbStairs(n));
        }
    }
}
