public class P695_MaxAreaOfLand {

    public static int maxAreaOfIsLand(int[][] grid) {
        int maxArea = 0;
        if (grid.length == 0) return maxArea;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int currArea = dfsMarking(grid, i, j);
                    maxArea = Math.max(maxArea, currArea);
                }
            }
        }
        return maxArea;
    }

    public static int dfsMarking(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int counter = 1; // count current cell aswell
        counter += dfsMarking(grid, i+1, j);
        counter += dfsMarking(grid, i-1, j);
        counter += dfsMarking(grid, i, j+1);
        counter += dfsMarking(grid, i, j-1);
        
        return counter;
    } 
    
    public static void main(String[] args) {
        int[][] grid = {
                        {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                    };
        System.out.println(maxAreaOfIsLand(grid));

    }
}
