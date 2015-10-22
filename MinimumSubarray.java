public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        int globalMinSum = nums.get(0);
        int sum = nums.get(0);
        
        for(int i = 1; i < nums.size(); i++) {
            
            int temp = nums.get(i);
            
            if(sum > 0) {
                sum = temp;
                globalMinSum = Math.min(globalMinSum, sum);
            } else {
                sum += temp;
                if(sum <= 0) {
                    globalMinSum = Math.min(globalMinSum, sum);
                } else {
                    sum = temp;
                }
            }
            
        }
        return globalMinSum;
    }
}