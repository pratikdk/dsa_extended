import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


public class P78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) { 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1); // since no repetition for same index i // similar bounds as combsum2
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3},
            {0}
        };
        for (int[] prob: probs) {
            System.out.println(subsets(prob));
        }
    }
}
