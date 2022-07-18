public class P55_JumpGame {

    public static boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++) { // i should not exceeed reach, be strict
            reach = Math.max(reach, i + nums[i]); // past reach vs reach from current index(i+nums[0])
        }
        return i == nums.length; // if we can reach final element, i++ happens and so we can check i to be == to length of nums 
    }

    public static void main(String[] args) {
        int[][] probs = {
            {2,3,1,1,4},
            {3,2,1,0,4},
            {1, 2, 0, 0, 1},
            {2, 0, 0},
            {0},
            {5, 2, 1},
            {1, 1, 2, 2, 0, 0},
            {0, 1}
        };
        for (int[] prob: probs) {
            System.out.println(canJump(prob));
        }
    }
}