public class P11_ContainerWithMostWater {
    public static int maxArea(int[] nums) {
        int l = 0, r = nums.length-1;
        int max = Integer.MIN_VALUE;
        while (l < r) {
            int currArea = 0;
            
            if (nums[l] <= nums[r]) {
                currArea = (r-l)*nums[l];
                l++;
            } else {
                currArea = (r-l)*nums[r];
                r--;
            }
            max = Math.max(max, currArea);
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {1,8,6,2,5,4,8,3,7},
            {1,1},
            {4,3,2,1,4},
            {1,2,1}
        };
        for (int[] nums: probs) {
            System.out.println(maxArea(nums));
        }
    }
}
