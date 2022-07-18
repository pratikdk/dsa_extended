public class P744_FIndSmallestLetterGreaterThanTargetCyclic {

    /****** incorrect solution ******/
    public static int nextGreatestNumber2(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int mid = 0;

        while (l <= r) {
            // check if target is out of bounds; i.e not within left,right
            if (nums[l] < nums[r] && target > nums[r]) { // similar to p33 only this single condition; 
                r++;
                break;
            }

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
        return nums[r % nums.length];
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{7, 9, 10, 11, 2, 4, 5}, {3}}, // 2
            {{0, 1, 2, 3, 4}, {8}}, // 0
            {{6, 1, 3, 4}, {9}}, // 1
        };
        for (int[][] prob: probs) {
            System.out.println(nextGreatestNumber2(prob[0], prob[1][0]));
        }
    }
}
