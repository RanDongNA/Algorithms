public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        if(grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == true) {
                    count++;
                    discoverIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    private void discoverIsland(boolean[][] grid, int x, int y) {
        if(grid[x][y] == false) {
            return;
        }
        
        grid[x][y] = false;

        if(x + 1 < grid.length) {
            discoverIsland(grid, x + 1, y);
        }

        if(x - 1 >= 0 ) {
            discoverIsland(grid, x - 1, y);
        }

        if(y + 1 < grid[0].length) {
            discoverIsland(grid, x, y + 1);
        }

        if(y - 1 >= 0) {
            discoverIsland(grid, x, y - 1);
        }
    }
}
