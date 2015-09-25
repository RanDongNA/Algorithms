public class FindePeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        int len = nums.length;
        
        for(int i=0;i<len-1;i++) {
        	if(nums[i]>nums[i+1]) 
        		return i;
        }

        return len-1;
    }
}