import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P217_ContainsDuplicate {

    public static boolean contains_sol1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains_sol2(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static boolean contains_sol3(int[] nums) { // contains duplicate or broken seq
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]-nums[i-1] != 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3,1},
            {1,2,3,4},
            {1,1,1,3,3,4,3,2,4,2},
            {1, 3, 4}
        };
        for (int i = 0; i < probs.length; i++) {
            System.out.println(contains_sol3(probs[i]));
        }
    } 
}