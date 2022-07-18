import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int l = i+1, r = nums.length-1;
                int sum;
                while (l < r) {
                    sum = nums[i] + nums[l] + nums[r];
                    if (sum < 0) {
                        l++;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r])); 
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l-1]) {l++;}
                        while (l < r && nums[r] == nums[r+1]) {r--;} 
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {-1,0,1,2,-1,-4},
            {},
            {0},
            {-3,3,4,-3,1,2}
        };
        for (int[] nums: probs) {
            System.out.println(threeSum(nums));
        }
    }
}
