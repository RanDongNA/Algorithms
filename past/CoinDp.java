public class CoinDp {
	private int[] coins = new int[] {1,5,10,25,100};

	public int minCoin(int value) {
		int[] dp = new int[value+1];
		dp[0] = 0;
		for(int i=1;i<=value;i++) {
			if(dp[i]==0) {
				int min = Integer.MAX_VALUE;
				for(int coin:coins) {

					if(i-coin>=0)
						if(dp[i-coin]<min)
							min =  dp[i-coin];
					//System.out.println("min: "+min);
				}
				if(min<Integer.MAX_VALUE)
					dp[i]=min+1;
			} else {
				continue;
			}
		}
		System.out.println("dp:");
		for(int i:dp) System.out.print(i+" ");
		return dp[value];
	}

	public static void main(String[] args) {
		CoinDp cd = new CoinDp();
		//for(int i=1;i<=20;i++)
			
		System.out.println("\n"+15+": "+cd.minCoin(15));
	}
}