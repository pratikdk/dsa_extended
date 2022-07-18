import java.util.Arrays;

public class P16_3SumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[n-1];
        for (int i = 0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
            }
        }
        return closestSum;
    }
    public static int threeSumClosest2(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0] + num[1] + num[num.length - 1];
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[][][] probs = {
            // {{-1,2,1,-4}, {4}},
            // {{0,0,0}, {1}},
            {{1,1,-1,-1,3},{-1}}
        };
        for (int[][] prob: probs) {
            System.out.println(threeSumClosest2(prob[0], prob[0][1]));
        }
    } 
}
