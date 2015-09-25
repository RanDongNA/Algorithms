public class Stock3 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;
    	int[] dp1 = new int[prices.length+1];
    	dp1[0]=0;
    	System.out.println("hi");

    	int buy, sell,result,trueResult;
    	trueResult = 0;
    	result = 0;
    	buy = prices[0];
    	sell = buy;

    	for(int i=0;i<prices.length;i++) {
    		sell = prices[i];
    		int profit = sell-buy;
    		if(profit>=0) {
    			if(profit>result)
    				result = profit;
    		} else {
    			buy = prices[i];
    		}
    		dp1[i+1] = result;
    	}
    	result = 0;
    	buy = prices[prices.length-1];
    	for(int i=prices.length-1;i>=0;i--) {
    		sell = prices[i];
    		int profit = buy-sell;
    		if(profit>=0) {
    			if(profit>result)
    				result = profit;
    		} else {
    			buy = prices[i];
    		}
    		int temp = dp1[i]+result;
    		if(temp>trueResult) {
    			trueResult = temp;
    		}
    	}

    	return trueResult;
    }
}
 [2,1,4,5,2,9,7]