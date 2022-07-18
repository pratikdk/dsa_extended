import java.util.Arrays;

public class P73_SetMatrixZeros {

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1; // first column
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) { // first look at 0th column value for row i, if zero store it. Now (i, 0) is safe for overridding
                col0 = 0;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }   
            }
        }
        // System.out.println(Arrays.deepToString(matrix));
        // 0's state stored in first row & col, when doing inplace activation avoid iterating from top(invalidates the state)
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // activate(with 0) i'th row's 0th col if col0 == 0;
            if (col0 == 0) {
                matrix[i][0] = 0;
            }  
        }
    }
    public static void main(String[] args) {
        int[][][] probs = {
            {{1,1,1},{1,1,1},{1,1,1}},
            {{0,1,2,0},{3,4,5,2},{1,3,1,5}}
        };
        for (int[][] matrix: probs) {
            setZeroes(matrix);
            System.out.println(Arrays.deepToString(matrix));
        }
    }
}
