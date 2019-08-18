 public class JumpGame2 {
    public int jump(int[] nums) {
        
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return 0;
        }

        int index = 0, count = 0;
        int reach = nums[index];
        int target = nums.length - 1;
        // 
        while(reach > 0) {
            
            if(reach >= target - index) {
                return count + 1;
            }

            int newReach = 0;
            while(reach > 0) {
                index++;
                reach--;
                newReach = Math.max(newReach, nums[index] - reach);
            }
            count++;
            reach = newReach;
        }

        return -1;
    }
}