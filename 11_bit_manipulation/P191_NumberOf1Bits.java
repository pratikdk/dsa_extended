public class P191_NumberOf1Bits {

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
    // public static int hammingWeight(int n) {
    //     int ones = 0;
    //         while(n!=0) {
    //             ones = ones + (n & 1);
    //             n = n>>>1;
    //         }
    //         return ones;
    // }
    
    public static void main(String[] args) {
        int[] probs = {11, 128, -3};
        for (int prob: probs) {
            System.out.println(hammingWeight(prob));
        }
    }
}
