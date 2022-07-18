import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int numRows = matrix.length;
        int numCols = matrix[0].length;
        if (numRows == 0 || numCols == 0) return res;
        int[] nSteps = {numCols, numRows-1};

        int iDir = 0; // Initial direction
        int ir = 0, ic = -1; // Initial position
        while (nSteps[iDir%2] != 0) { // current direction not yet scanned
            for (int i = 0; i < nSteps[iDir%2]; i++) {
                ir += dirs[iDir][0];
                ic += dirs[iDir][1];
                res.add(matrix[ir][ic]);
            }
            nSteps[iDir%2]--;
            iDir = (iDir + 1) % 4; // wrap to index 4 direction
        }

        return res;
    }

    // Clean solution: https://www.youtube.com/watch?v=BJnMZNwUk1M
    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            // top row; left to right
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top += 1; // top row scanned; reduce (i.e increase to omit)

            // right column; top to bottom
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right-1]);
            }
            right -= 1; // right column scanned; reduce

            // Imagine scanning a 1xm or mx1 matrix, when sweep completes,; polar sides overlap 
            if (left == right || top == bottom) { 
                break;
            }

            // bottom row; right to left
            for (int i = right-1; i > left-1; i--) {
                res.add(matrix[bottom-1][i]);
            }
            bottom -= 1; // bottom column scanned; reduce 

            // left row; bottom to top
            for (int i = bottom-1; i > top-1; i--) {
                res.add(matrix[i][left]);
            }
            left += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][][] probs = {
            {
                {1,   2,   3,   4,   5,   6},
                {7,   8,   9,   10,  11,  12},
                {13,  14,  15,  16,  17,  18},
                {19,  20,  21,  22,  23,  24},
                {25,  26,  27,  28,  29,  30}
            },
            {
                {1,2,3},
                {4,5,6},
                {7,8,9}
            },
            {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
            }
        };
        for (int[][] matrix: probs) {
            System.out.println(spiralOrder2(matrix));
        }
    }
}