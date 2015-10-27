class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;

        int[] diff = new int[len];
        diff[0] = 0;

        // length = x
        int[] candidateResult = new int[len + 1];
        candidateResult[0] = 0;
        candidateResult[1] = 0;
        // length = x
        int[] candidateResultRight = new int[len + 1];
        candidateResultRight[len - 1] = 0;
        candidateResultRight[len] = 0;

        int profit = 0;
        for(int i = 1; i < len; i++) {
            diff[i] = prices[i] - prices[i - 1];
            profit += diff[i];
            if(profit < 0) {
                profit = 0;
            }
            candidateResult[i + 1] = 
                Math.max(candidateResult[i], profit);
        }

        profit = 0;
        for(int j = len - 1; j > 0; j--) {
            profit += diff[j];
            if(profit < 0) {
                profit = 0;
            }
            candidateResultRight[j - 1] = 
                Math.max(candidateResultRight[j], profit);
        }

        int maxResult = 0;
        for(int i = 0; i <= len; i++) {
            maxResult = Math.max(
                maxResult, 
                candidateResult[i] + candidateResultRight[i]
            );
        }
        
        return maxResult;
    }
}
