public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = target.length;
        int left = 0;
        int right = len - 1;
        int count = 0;
        while(left < right) {
            int sum = nums[left] + nums[right];
            if( sum >= target) {
                count += right - left;
                left++;
                right--;
            } else {
                left++;
            }
        }

        return count;
    }
}
