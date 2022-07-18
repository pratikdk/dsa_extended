public class P152_MaximumProductSubarray {
    // public static int maxProduct(int[] nums) { 
    //     int max = nums[0];
    //     for (int i = 1, imax = max, imin = max; i < nums.length; i++) {
    //         if (nums[i] < 0) { // negative mutliplication makes small values bigger, big values smaller.
    //             int temp = imax;
    //             imax = imin;
    //             imin = temp;
    //         }
    //         imax = Math.max(nums[i], imax * nums[i]); // when nums[i] == 0, imax = 0
    //         imin = Math.min(nums[i], imin * nums[i]); // when nums[i] == 0, imin = 0

    //         max = Math.max(max, imax);
    //     }
    //     return max;
    // }

    public static int maxProduct(int[] nums) { 
        int max = nums[0];
        for (int i = 1, imax = max, imin = max; i < nums.length; i++) {
            if (nums[i] < 0) { // negative mutliplication makes small values bigger, big values smaller.
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], imax * nums[i]); // when nums[i] == 0, imax = 0
            imin = Math.min(nums[i], imin * nums[i]); // when nums[i] == 0, imin = 0

            max = Math.max(max, imax); // save max before subsequent multiplications reduce it. 
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {-2,1,-3,4,-1,2,1,-5,4},
            {1},
            {-1},
            {2,3,-2,4},
            {5,4,-1,7,8}
        }; 
        for (int[] prob: probs) {
            System.out.println(maxProduct(prob));
        }
    }
}
