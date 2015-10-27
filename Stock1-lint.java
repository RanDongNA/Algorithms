public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int result = 0;
        int [] prefixArray = new int[prices.length];
        prefixArray[0] = 0;

        for(int i = 1; i < prices.length; i++) {
            prefixArray[i] = prices[i] - prices[i - 1];
            profit += prefixArray[i];
            if(profit < 0) {
                profit = 0;
            } else {
                result = Math.max(result, profit);
            }
        }
        
        return result;
    }
}