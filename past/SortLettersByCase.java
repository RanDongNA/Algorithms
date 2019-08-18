public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if(chars == null || chars.length == 0) {
            return;
        }
        
        int len = chars.length;
        int left = 0;
        int right = len - 1;
        
        while(left < right && isLower(chars[left])) {
                left++;
        }
        while(left < right && !isLower(chars[right])) {
                right--;
        }

        while(left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            while(left < right && isLower(chars[left])) {
                left++;
            }

            right--;
            while(left < right && !isLower(chars[right])) {
                right--;
            }
        }
    }
    
    public boolean isLower(char ch) {
        int asc = (int)ch;
        return ch > 96;
    }
}

