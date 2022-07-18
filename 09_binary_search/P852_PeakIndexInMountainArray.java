public class P852_PeakIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] nums) {
        int left = 0, right = nums.length-1, mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] < nums[mid+1]) {
                left = mid+1;
            } else {
                right = mid; 
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {0,1,0},
            {0,2,1,0},
            {0,3,10,5,2},
            {0,2,4,6,10,2}
        };
        for (int[] prob: probs) {
            System.out.println(peakIndexInMountainArray(prob));
        }
    }
}
