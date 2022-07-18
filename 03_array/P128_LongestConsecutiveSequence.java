import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P128_LongestConsecutiveSequence {
    public static int longestConsecutive_sol1(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) { // don't break, when elem at i == i-1
                if (nums[i] == nums[i-1]+1) {
                    curr += 1;
                } else {
                    max = Math.max(max, curr);
                    curr = 1;
                }
            }
        }
        return Math.max(max, curr); // also considers curr for last index
    }

    public static int longestConsecutive_sol2(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num: nums) {
            numSet.add(num);
        }

        int max = 0;

        for (Integer num: numSet) {
            if (!numSet.contains(num-1)) { // only count from begining of seq
                int currNum = num;
                int currStreak = 1;

                while (numSet.contains(currNum+1)) {
                    currStreak += 1;
                    currNum += 1;
                }
                // Streak broken compare with max
                max = Math.max(max, currStreak);
            }
        }
        
        return max;
    }


    // public static int longestConsecutive_sol1(int[] nums) {
    //     if (nums.length == 0) return 0;
    //     Arrays.sort(nums);
    //     int max = 0;
    //     int curr = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (nums[i] != nums[i-1]) { // don't break, when elem at i == i-1
    //             if (nums[i] == nums[i-1]+1) {
    //                 curr += 1;
    //             } else {
    //                 curr = 1;
    //             }
    //         }
    //         max = Math.max(max, curr);
    //     }
    //     return max;
    // }
    
    public static void main(String[] args) {
        int[][] probs = {
            {100,4,200,1,3,8},
            {0,3,7,2,5,8,4,6,0,1}
        };
        for (int[] nums: probs) {
            System.out.println(longestConsecutive_sol2(nums));
        }
    }
}
