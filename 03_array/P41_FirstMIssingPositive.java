public class P41_FirstMIssingPositive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n  &&  nums[i] != nums[nums[i]-1]) { // within 1 to n and not at proper index
                // swap
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,2,0},
            {3,4,-1,1},
            {7,9,11,6,12}
        };
        for (int[] prob: probs) {
            System.out.println(firstMissingPositive(prob));
        }
    }
}
