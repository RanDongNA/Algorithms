class BestTimeSellStock2 
{
	public static void main(String[] args) 
	{
		int[] prices = {1,2};
		System.out.println("max profit: "+(new BestTimeSellStock2()).maxProfit(prices));
	}
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
		int profit=0;
		int buyAt=prices[0];
		int sellAt=prices[0];
		for(int i=1;i<prices.length;i++) {
			if(sellAt<prices[i]) {
				sellAt=prices[i];
			} else {
				profit+=(sellAt-buyAt);
				buyAt=prices[i];
				sellAt=prices[i];
			}
			System.out.println("butAt="+buyAt+" sellAt="+sellAt);
		}
		profit+=(sellAt-buyAt);
		return profit;

	}
}
