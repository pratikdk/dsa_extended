public class P509_FibonacciNumber {
    public static int fib(int n) {
        int fdp2 = 0;
        int fdp1 = 1;
        if (n == 0) return fdp2;
        if (n == 1) return fdp1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = fdp1 + fdp2;
            fdp2 = fdp1;
            fdp1 = sum;
        }
        return fdp1;
    }

    public static void main(String[] args) {
        int[] probs = {
            2,
            3,
            4
        };
        for (int n: probs) {
            System.out.println(fib(n));
        }
    }
}