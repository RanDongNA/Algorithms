public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++) {
            localMax += nums[i];
            globalMax = Math.max(globalMax, localMax);
            localMax = Math.max(localMax, 0);

            // if(localMax < 0) {
            //     localMax = temp;
            //     globalMax = Math.max(globalMax, localMax);
            // } else {
            //     localMax += temp;
            //     if(localMax > 0) {
            //         globalMax = Math.max(globalMax, localMax);
            //     } else {
            //         localMax = temp;
            //     }
            // }


        }

        return globalMax;
    }
}
