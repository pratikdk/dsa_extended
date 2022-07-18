import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P167_TwoSum2 {
    public static int[] twoSum2_sol1(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int sum;
        int[] res = new int[2];
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res[0] = nums[l];
                res[1] = nums[r];
                l++;
                r--;
                while (l < r && nums[l] == nums[l-1]) {l++;}
                while (l < r && nums[r] == nums[r+1]) {r--;} 
            }
        }
        return res;
    }

    public static List<List<Integer>> twoSum2_sol2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                res.add(new ArrayList<>(Arrays.asList(nums[l], nums[r])));
                l++;
                r--;
                while (l < r && nums[l] == nums[l-1]) {l++;}
                while (l < r && nums[r] == nums[r+1]) {r--;} 
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {{2,7,11,15}, {9}},
            {{3,2,4}, {6}},
            {{3,3}, {6}},
            {{1,2,3,4,5,6,7,8}, {9}}
        };
        for (int[][] prob: probs) {
            System.out.println(Arrays.toString(twoSum2_sol1(prob[0], prob[1][0])));
            // System.out.println(twoSum2_sol2(prob[0], prob[1][0]));
        }
    }
}
