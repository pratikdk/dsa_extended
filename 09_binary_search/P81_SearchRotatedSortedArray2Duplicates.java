public class P81_SearchRotatedSortedArray2Duplicates {

    ////// * See problem 33 * //////
    public static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            if (nums[mid] == target) {
                return true;
            }
            // helps forward loop to compelete the while loop and return false; [2, 2] target 1
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) { // edge case, both halfs non increasing
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]) { // first half is sorted
                if (nums[left] <= target && target < nums[mid]) { // if within sorted bounds
                    right = mid-1;
                } else { // explore other half
                    left = mid+1;
                }
            } else { // second half is sorted
                if (nums[mid] < target && target <= nums[right]) { // if within sorted bounds
                    left = mid+1;
                } else { // explore other half
                    right = mid-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{4,5,6,7,0,1,2}, {0}},
            {{4,5,6,7,0,1,2}, {3}},
            {{3,4,5,1,2}, {4}},
            {{4,5,6,7,0,1,2}, {6}},
            {{11,13,15,17}, {15}}
            // 4 1 2 4 4 4 4
        };
        for (int[][] prob: probs) {
            System.out.println(search(prob[0], prob[1][0]));
        }
    }
}
