public class P136_SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num; // xor
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {2,2,1},
            {4,1,2,1,2},
            {1}
        };
        for (int[] nums: probs) {
            System.out.println(singleNumber(nums));
        }
    }
}
