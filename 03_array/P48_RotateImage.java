import java.util.Arrays;

public class P48_RotateImage {
    public static void rotate(int[][] matrix) {
        int n = matrix.length-1;
        for (int i = 0; i < (n+1)/2; i++) {
            for (int j = i; j < n-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }

    public static void rotate2(int[][] matrix) {
        int n = matrix.length-1;
        for (int i = 0; i < matrix.length/2; i++) {
            for (int j = i; j < n-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {
                {1,2,3},
                {4,5,6},
                {7,8,9}},
            {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
            },
            {
                {1}
            },
            {
                {1,2},
                {3,4}
            }
        };
        for (int[][] matrix: probs) {
            rotate2(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
