public class P42_TrapRainWater {

    public static int trap(int[] bars) {
        int n = bars.length;
        int left = 0, right = n-1;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) { // <= because, ex: [5 2 1] we need calculate water at 2 as well
            if (bars[left] <= bars[right]) { // choose smaller bar
                if (bars[left] >= maxLeft) maxLeft = bars[left]; // look at smaller side; consider local max
                else res += maxLeft - bars[left];
                left++; 
            } else {
                if (bars[right] >= maxRight) maxRight = bars[right];
                else res += maxRight - bars[right];
                right--;
            }
        }
        return res;
    } // a currmax is bounded by other max, hence we compute water diff at currentmax - curr
    public static void main(String[] args) {
        int[][] probs = { 
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {4,2,0,3,2,5}
        };
        for (int[] prob: probs) {
            System.out.println(trap(prob));
        }
    }
}
