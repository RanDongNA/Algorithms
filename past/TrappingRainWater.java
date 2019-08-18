public class TrappingRainWater {
    public int trap(int[] height) {
        
        if(height == null || height.length < 3) {
            return 0;
        }

        int result = 0;

        int left = 0;
        int right = height.length - 1;
        int waterLevel = height[left] > height[right] ? height[right] : height[left];
        
        while(left < right) {


            if(height[left] <= waterLevel) {

                // if left is the lower one
                //      lower than water level
                //      or the lower one in {left, right}
                left++;

                // left changed
                if(height[left] <= waterLevel) {
                    // height[left] < waterLevel < height[right] 

                    result += waterLevel - height[left];
                
                } else if(height[right] < height[left]) {
                    // waterLevel < height[right] < height[left] 
                    
                    waterLevel = height[right];
                
                } else {                
                    // waterLevel < height[left] < height[right] 
                    
                    waterLevel = height[left];
                }

            } else {

                // if right is the lower one
                right--;

                // right changed
                if(height[right] <= waterLevel) {
                    // height[right] < waterLevel < height[left] 
                    
                    result += waterLevel - height[right];

                } else if(height[left] < height[right]) {
                    // waterLevel < height[left] < height[right]
                    
                    waterLevel = height[left];

                } else { 
                    // waterLevel < height[right] < height[left]
                    
                    waterLevel = height[right];
                }
            }
        }

        return result;
    }
}