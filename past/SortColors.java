class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int headPtr = 0;
        int tailPtr = nums.length - 1;
        
        while(nums[headPtr] == 0) {
            headPtr++;
        }
        while(nums[tailPtr] == 2) {
            tailPtr--;
        }
        
        for(int i = headPtr; headPtr < tailPtr && i <= tailPtr; ) {
            if(nums[i] == 0) {
                nums[i] = nums[headPtr];
                nums[headPtr] = 0;
                
                while(nums[headPtr] == 0) {
                        headPtr++;
                }
                
                if(headPtr > i) {
                    i = headPtr;
                }
                
            } else if(nums[i] == 2) {
                nums[i] = nums[tailPtr];
                nums[tailPtr] = 2;
                while(nums[tailPtr] == 2) {
                    tailPtr--;
                }
            } else {
                i++;
            }
        }
    }
}
