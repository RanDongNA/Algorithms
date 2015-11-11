public class Solution {
    /** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        while(left < len && nums[left] < k) {
            left++;
        }

        while(right >= 0 && nums[right] >= k) {
            right--;
        }

        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            while(left < len && nums[left] < k) {
                left++;
            }

            right--;
            while(right >= 0 && nums[right] >= k) {
                right--;
            }
        }

        return left;
    }
}
