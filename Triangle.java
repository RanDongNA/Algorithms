public class Triangle {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     * space O(n^2) solution
     */
    public int minimumTotal(int[][] triangle) {
        if(triangle == null || triangle.length == 0) {
            return 0;
        }
        if(triangle[0] == null || triangle.length == 0) {
            return 0;
        } 
        int rows = triangle.length;
        int cols = triangle[rows - 1].length;

        int [][] f = new int[rows][cols];
        for(int i = 0; i < cols; i++) {
            f[rows - 1][i] = triangle[rows - 1][i];
        }

        for(int i = rows - 2; i >= 0; i--) {
            for(int j = 0; j < triangle[i].length; j++) {
                f[i][j] = triangle[i][j]
                            + Math.min(f[i - 1][j],
                                       f[i - 1][j + 1]);
            }
        }

        return f[0][0];
    }

    // space O(n) solution
    // TO-DO
    public int minimumTotal2(int [][] triangle) {
        if(triangle == null || triangle.length == 0) {
            return 0;
        }
        if(triangle[0] == null || triangle.length == 0) {
            return 0;
        }

        int rows = triangle.length;
        int cols = triangle[rows - 1].length;
        int[] f = new int[rows];
        f[cols - 1] = triangle[rows - 1][cols - 1];

        for(int i = cols - 2; i >= 0; i--) {
            f[rows - 2] = triangle[rows - 2][i] 
                        + Math.min(triangle[rows - 1][i], f[rows -1]);
            for(int j = rows - 3; j >= 0; j--) {
                f[j] = triangle[j][i] + Math.min()
            }
        }
    }
}


[
     [2],
     [3,4],
     [6,5,7],
     [4,1,8,3]
]

O(n) ? n = rows