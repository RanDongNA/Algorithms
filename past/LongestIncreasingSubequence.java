public class LongestIncreasingSubsequence {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int[] lengthCount = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            lengthCount[i] = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] <= nums[i]) {
                    lengthCount[i] = Math.max(lengthCount[i], lengthCount[j]);
                }
            }
            lengthCount[i]++;
            max = Math.max(lengthCount[i], max);
        }

        return max;
    }
}

