public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2) {
            return 0;
        }
        int len = nums.size();
        
        int[] maxFromLeft = new int[len];
        int[] maxFromRight = new int[len];

        maxFromLeft[0] = nums.get(0);
        maxFromRight[len - 1] = nums.get(len - 1);

        int sum = maxFromLeft[0];

        for(int i = 1; i < len - 1; i++) {
            sum = Math.max(nums.get(i), sum + nums.get(i));
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], sum);
        }

        sum = maxFromRight[len - 1];

        for(int i = len - 2; i > 0; i--) {
            sum = Math.max(nums.get(i), sum + nums.get(i));
            maxFromRight[i] = Math.max(maxFromRight[i + 1], sum);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < len - 1; i++) {
            max = Math.max(maxFromLeft[i] + maxFromRight[i + 1], max);
        }

        return max;
    }
}


