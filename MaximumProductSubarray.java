public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int max;
        Stack<Integer> stack = new Stack<Integer>();
        int product = 1;

        for(int i = 0; i < nums.length(); i++) {
            if(nums[i] == 0)｛
                stack.push(product);
                max = Math.max(max, product);
                product = 1;
            } else if(nums[i] < 0) {
                if(!stack.empty() && stack.peek() < 0) {
                    product *= nums[i];
                    product *= stack.peek();
                    stack.push(product);
                    max = Math.max(product, max);
                } else {
                    max = Math.max(product);
                    product *= nums[i];
                    stack.push(product);
                }
            }
        }
        return Math.max(product, max);
    }
}



// -1 -2 -3 ...
// 0