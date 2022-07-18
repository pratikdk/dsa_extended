public class P287_FindDuplicateNumber {
    // Strange caveat entry of loop specifically at 0th index
    // also element values are in range 1 to n-1
    // doesn't work for {9, 10, 11, 9},
    
    public static int findDuplicate(int[] nums) {
        if (nums.length > 0) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,3,4,2,2},
            {3,1,3,4,2},
            {1,1},
            // {9, 10, 11, 9},
            {2,2,2,2,2}
        };
        for (int[] nums: probs) {
            System.out.println(findDuplicate(nums));
        }
    }   
}
