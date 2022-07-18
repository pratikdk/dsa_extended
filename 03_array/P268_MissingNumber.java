public class P268_MissingNumber {

    public static int missingNumber(int[] nums) {
        int n = nums.length; // implication for this problem is, n is perceived as n+1, hence gauss(1->n) works.
        int gaussSum = (n*(n+1))/2;
        int actualSum = 0;
        for (int num: nums) {
            actualSum += num;
        }
        return gaussSum-actualSum; // its assumed that gauss sum will be higher(1->n)
    }
    
    public static void main(String[] args) {
        int[][] probs = {
            {3,0,1},
            {0,1},
            {9,6,4,2,3,5,7,0,1},
            {0}
        };
        for (int[] nums: probs) {
            System.out.println(missingNumber(nums));
        }
    }
}
