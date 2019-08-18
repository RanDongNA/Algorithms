class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        int [] record = new int[k];

        for(int i = 0; i < colors.length; i++) {
            record[colors[i] - 1]++;
        }

        int index = 0;
        for(int color = 1; color <= k; color++) {
            for(int i = 1; i <= record[color - 1]; i++) {
                colors[index] = color;
                index++;    
            }            
        }
    }

    // other way without O(k) space
    public void sortColors2(int[] colors, int k) {
        if(colors == null || colors.length == 0) {
            return;
        }

        int len = colors.length;
        int doPtr = 0;
        
        for(int color = 1; color <= k; color++) {
            for(int comparePtr = doPtr; comparePtr < len; ) {
                if(comparePtr == doPtr && colors[comparePtr] == color) {
                    comparePtr++;
                    doPtr++:
                    continue;
                } else if(colors[comparePtr] == color ) {
                    colors[comparePtr] = colors[doPtr];
                    colors[doPtr] = color;
                    doPtr++;
                } 

                if(colors[comparePtr] != color) {
                        comparePtr++;
                }
            }
        }   
    }
}
