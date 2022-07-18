import java.util.Arrays;

public class P238_ProductOfArrayExceptSelf {

    public static int[] product(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int l = 1;
        int r = 1;
        int nIdx = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                res[i] *= l;
                res[nIdx-i] *= r;
            }
            l *= nums[i];
            r *= nums[nIdx-i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] probs = {
            {1,2,3,4},
            {-1,1,0,-3,3}
        };
        for (int[] prob: probs) {
            System.out.println(Arrays.toString(product(prob)));
        }
    }
}
