public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < prefixSum.length; i++) {
            for(int j = i + 1; j < prefixSum.length; j++) {
                if(prefixSum[i] == prefixSum[j]) {
                    result.add(i + 1);
                    result.add(j);
                    return result;
                }
            }
        }

        return result;
    }
}
