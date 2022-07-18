import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


public class P47_Permutations2 {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {             // i-1 shoud be used; Eg: 1, 1, 2 (i-1 prev added to same set); only diff
                if (used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) { // 1 2 2, former 2 should precede later 2  
                    continue;
                }
                tempList.add(nums[i]);
                used[i] = true;
                backtrack(list, tempList, nums, used);
                tempList.remove(tempList.size()-1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[][] probs = {
            {1,1,2},
            {1,2,3},
            {3,3,0,3}
        };
        for (int[] prob: probs) {
            System.out.println(permuteUnique(prob));
        }
    }
}
