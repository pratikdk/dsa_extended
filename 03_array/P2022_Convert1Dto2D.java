import java.util.Arrays;

public class P2022_Convert1Dto2D {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length) {return new int[0][0];}

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[j+(n*i)];
            }
        }

        return res;
    }
    public static void main(String[] args) {
        int[][][] probs = {
            {{1,2,3,4}, {2}, {2}},
            {{1,2,3}, {1}, {3}},
            {{1,2}, {1}, {1}},
            {{3}, {1}, {2}},
        };
        for (int[][] prob: probs) {
            System.out.println(Arrays.deepToString(construct2DArray(prob[0], prob[1][0], prob[2][0])));
        }
    }
}
