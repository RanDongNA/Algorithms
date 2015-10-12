public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length < 2) {
            return true;
        }

        int index = 0;
        int reach = nums[index];
        int target = nums.length - 1;

        while(reach > 0) {
            if(reach >= target - index) {
                return true;
            }

            int newReach = 0;
            while(reach > 0) {
                index++;
                reach--;
                newReach = Math.max(newReach, nums[index] - reach);
            }

            reach = newReach;
        }

        return false;
    }
}