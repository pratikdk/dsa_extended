public class P704_BinarySearch {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{-1,0,3,5,9,12}, {9}},
            {{-1,0,3,5,9,12}, {2}},
            {{1,2,30,42,100}, {42}},
            {{11,13,15,17}, {15}}
        };
        for (int[][] prob: probs) {
            System.out.println(search(prob[0], prob[1][0]));
        }
    }
}
