import java.util.Arrays;

public class P977_SquaresOfASortedArray {
    
    // public static int[] sortedSquares(int[] nums) {
    //     int n = nums.length;
    //     int left = 0, right = 0;
    //     while (right < n && nums[right] < 0) {
    //         right++;
    //     }
    //     left = right-1;
    //     int[] res = new int[n];
    //     int i = 0;
    //     while (left >= 0 || right < n) {
    //         if (left >= 0 && right < n) {
    //             if (Math.abs(nums[left]) <= Math.abs(nums[right])) {
    //                 res[i] = nums[left];
    //                 left--;
    //             } else { // nums[right] < nums[right]
    //                 res[i] = nums[right];
    //                 right++;
    //             }
    //         } else if (left >= 0) {
    //             res[i] = Math.abs(nums[left]);
    //             left--;
    //         } else { // right < n
    //             res[i] = Math.abs(nums[right]);
    //             right++;
    //         }
    //         res[i] = (int) Math.pow(res[i], 2);
    //         i++;
    //     }
    //     return res;
    // }

    // Better version
    // compare extremes and 
    // public int[] sortedSquares(int[] A) {
    //     int n = A.length;
    //     int[] result = new int[n];
    //     int i = 0, j = n - 1;
    //     for (int p = n - 1; p >= 0; p--) {
    //         if (Math.abs(A[i]) > Math.abs(A[j])) {
    //             result[p] = A[i] * A[i];
    //             i++;
    //         } else {
    //             result[p] = A[j] * A[j];
    //             j--;
    //         }
    //     }
    //     return result;
    // }

    public static int[] sortedSquares2(int[] nums) {
        int[] res = new int[nums.length];
        int i = nums.length-1;

        int left = 0, right = nums.length-1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[i] = nums[left] * nums[left];
                left++;
            } else {
                res[i] = nums[right] * nums[right];
                right--;
            }
            i--;
        }
        
        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {-4,-1,0,3,10},
            {-7,-3,2,3,11},
            {-3,-2,-1}
        };
        for (int[] prob: probs) {
            System.out.println(Arrays.toString(sortedSquares2(prob)));
        }
    }
}
