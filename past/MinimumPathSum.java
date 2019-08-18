public class MinimumPathSum {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        if(grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        int [][] f = new int[row][col];
        
        f[0][0] = grid[0][0];
        for(int i = 1; i < row; i++) {
            f[i][0] = grid[i][0] + f[i - 1][0]; 
        }
        for(int i = 1; i < col; i++) {
            f[0][i] = grid[0][i] + f[0][i - 1];
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                f[i][j] = Math.min(f[i - 1][j] + f[i][j - 1])
                            + grid[i][j];
            }
        }

        return f[row - 1][col - 1];
    }
}

