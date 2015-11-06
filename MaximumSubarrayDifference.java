public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */

    // brute force
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2) {
            return 0;
        }
        
        int difference = Integer.MIN_VALUE;

        for(int endOfA = 0; endOfA < nums.size() - 1; endOfA++) {
            
            ResultType left = findMinAndMax(nums, 0, endOfA);
            ResultType right = findMinAndMax(nums, endOfA + 1, nums.size() - 1);
            
            int leftBigger = left.maxSum - right.minSum;
            int rightBigger = right.maxSum - left.minSum;
            leftBigger = leftBigger < 0 ? - leftBigger : leftBigger;
            rightBigger = rightBigger < 0 ? - rightBigger : rightBigger;
            
            difference = Math.max(
                difference, 
                Math.max(
                    leftBigger,
                    rightBigger
                )
            );
        }

        return difference;
    }

    public ResultType findMinAndMax(ArrayList<Integer> nums, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int maxSum = nums.get(start);
        int minSum = nums.get(start);
        int max = maxSum;
        int min = minSum;
        
        for(int i = start + 1; i <= end; i++) {
            maxSum = Math.max(nums.get(i), maxSum + nums.get(i));
            max = Math.max(max, maxSum);
            minSum = Math.min(nums.get(i), minSum + nums.get(i));
            min = Math.min(min, minSum);
        }

        return new ResultType(min, max);
    }

    class ResultType {
        int minSum;
        int maxSum;
        public ResultType(int min, int max) {
            this.minSum = min;
            this.maxSum = max;
        }
    }
}


