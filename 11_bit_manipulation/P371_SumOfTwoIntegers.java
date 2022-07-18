public class P371_SumOfTwoIntegers {
    // & get carryies
    // ^ get carryless output

    public static int getSum(int a, int b) {
        int c;
        while (b != 0) {
            c = (a & b);
            a = (a ^ b);
            b = c<<1;
        }   
        return a;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {1, 2},
            {2, 3},
            {2, 2},
            {3, 1},
            {3, 2},
            {0, 0},
            {-3, -10}
        };
        for (int[] prob: probs) {
            System.out.println(getSum(prob[0], prob[1]));
        }
    }   
}
