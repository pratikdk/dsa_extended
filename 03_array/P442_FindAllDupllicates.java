import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// only works for 1 -> n, no negatives
public class P442_FindAllDupllicates {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1; // get true index
            if (nums[index] < 0) { // check if nums[index] already marked as negative
                res.add(index+1);
            }
            nums[index] = -1 * Math.abs(nums[index]); // mark nums[index] as negative
        }
        System.out.println(">>> " + Arrays.toString(nums));

        return res;
    }

    public static void main(String[] args) {
        int[][] probs = {
            {4,3,2,7,8,2,3,1},
            {1,1,2},
            {1}
        };
        for (int[] prob: probs) {
            System.out.println(findDuplicates(prob));
        }
    }
}
