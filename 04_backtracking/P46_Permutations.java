import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)


public class P46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) { // loop bounds align with combination4
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    backtrack(list, tempList, nums);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }

    public static void main(String[] args){
        int[][] probs = {
            {1,2,3},
            {0,1}
        };
        for (int[] prob: probs) {
            System.out.println(permute(prob));
        }
    }
}
