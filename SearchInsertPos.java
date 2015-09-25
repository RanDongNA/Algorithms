public class Solution {
    
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length);
    }
    
    // binary search - Deferred detection of equality
    // by using this kind of binary search "The deferred detection algorithm has the advantage that 
    // if the keys are not unique, it returns the smallest index (the starting index) of the region 
    // where elements have the search key. The early termination version would return the first
    // match it found, and that match might be anywhere in region of equal keys."
    public int binarySearch(int[] nums, int target, int lo, int hi) {
        
        // From WiKi
        // inclusive indices
        //   0 <= imin when using truncate toward zero divide
        //     imid = (imin+imax)/2;    
        //   imin unrestricted when using truncate toward minus infinity divide
        //     imid = (imin+imax)>>1; or
        //     imid = (int)floor((imin+imax)/2.0);
        
        // continually narrow search until just one element remains
        while(lo<hi) {
            
            // use this fomular so eliminate the possibilities of OVERFLOW
            int mid = lo+ (hi-lo)/2;
            
            // reduce the search
            if(nums[mid]<target) {
                return binarySearch(nums,target,mid+1,hi);
            } else {
                return binarySearch(nums,target,lo,mid);
            }
        }
        if(lo==nums.length) 
            return lo;
        else if(lo==hi && nums[lo]>=target)
            return lo;
        else
            return lo+1;

    }
}