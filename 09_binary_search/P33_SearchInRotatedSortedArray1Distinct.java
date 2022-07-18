public class P33_SearchInRotatedSortedArray1Distinct {

    // https://www.youtube.com/watch?v=U8XENwh8Oy8
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid = 0;

        while (l <= r) {
            mid = (l+r)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) { // mid is in left half
                if (target > nums[mid] || target < nums[l]) { // move to right half
                    l = mid+1;
                } else { // move to left half
                    r = mid-1;
                }
            } else { // mid is in right half
                if (target < nums[mid] || target > nums[r]) { // if within sorted bounds
                    r = mid-1;
                } else { // explore other half
                    l = mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{4,5,6,7,0,1,2}, {0}},
            {{4,5,6,7,0,1,2}, {3}},
            {{3,4,5,1,2}, {4}},
            {{4,5,6,7,0,1,2}, {6}},
            {{11,13,15,17}, {15}}
            // 3, 4, 0, 1, 2
        };
        for (int[][] prob: probs) {
            System.out.println(search(prob[0], prob[1][0]));
        }
    }
}
