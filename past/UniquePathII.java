public class UniquePathII {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        if(obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid.length;
        int[][] f = new int[row][col];
        
        for(int i = 0; i < row; i++) {
            f[i][0] = 1;
        }
        for(int i = 0; i < col; i++) {
            f[0][i] = 1;
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j< col; j++) {
                if(obstacleGrid[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = f[i][j - 1] + f[i - 1][j];
                }

            }
        }

        return f[row][col];
    }
}
