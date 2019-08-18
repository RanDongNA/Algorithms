public class MinPathSum {
	public int minPathSum(int[][] grid) {
        
        // special case
		if(grid==null||grid.length==0) return 0;
        
		int len = grid[0].length;
		
		// dynamic programming chart
		int[] dp = new int[len];
		
		// init dp[0]
		dp[0] = grid[0][0];
		
		// first row just add up
		for(int i=1;i<len;i++) {
			dp[i] = dp[i-1] + grid[0][i];
		}
		
		// from the second row,
		// change dp[0] = dp[0] + grid[j][0];
		// change dp[i] = min(dp[i-1],dp[i]) + grid[j][i];
		for(int j=1;j<grid.length;j++) {
			dp[0] += grid[j][0];
			for(int i=1;i<len;i++) {
				int left = dp[i-1];
				int up = dp[i];
				dp[i] = grid[j][i] + (left>up?up:left);
			}
		}
		
		// result will be store in dp[dp.length-1]
		return dp[len-1];
	}	

	public static void main(String[] args) {
		MinPathSum mps = new MinPathSum();
		mps.minPathSum(new int[][]{{1,2},{1,1}});
	}	
}