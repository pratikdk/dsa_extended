import java.util.Arrays;

public class P75_SortColors {

    public static void sortColors(int[] nums) {
        int r = 0, b = nums.length-1;
        int w = 0;
        while (w <= b) {
            if (nums[w] == 2) { // blue, put right
                nums[w] = nums[b];
                nums[b] = 2;
                b--;
            } else if (nums[w] == 0) { // red, put left
                nums[w] = nums[r];
                nums[r] = 0;
                r++;
                w++;
            } else { // white, move ahead
                w++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] probs = {
            {2,0,2,1,1,0},
            {2,0,1},
            {2, 1},
            {1, 0, 2, 1, 0}
        };
        for (int[] prob: probs) {
            sortColors(prob);
            System.out.println(Arrays.toString(prob));
        }
    }
}
