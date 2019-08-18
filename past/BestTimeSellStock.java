class BestTimeSellStock 
{
	public static void main(String[] args) 
	{
		int[] prices = {5,5,0,10,10,6,5,5,5,5,5,5,5};
		System.out.println("max profit: "+(new BestTimeSellStock()).maxProfit(prices));
	}
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
        int[] maxPrice = new int[prices.length];
		int i = prices.length-1;
		maxPrice[i] = prices[i];
		int profit=0;
		for(int j=i-1;j>=0;j--) {
			int temprofit = maxPrice[j+1]-prices[j];
			if(temprofit > profit)
				profit = temprofit;
			if(prices[j] > maxPrice[j+1])
				maxPrice[j] = prices[j];
			else
				maxPrice[j] = maxPrice[j+1];
		}
		return profit;

	}
}
