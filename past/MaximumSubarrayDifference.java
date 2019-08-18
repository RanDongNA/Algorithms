public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */

    // let's try O(n) time and O(n) space
    // 2361 ms
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if(nums == null || nums.size() < 2) {
            return 0;
        }
        int len = nums.size();

        int[] minFromLeft = new int[len];
        int[] maxFromLeft = new int[len];
        int[] minFromRight = new int[len];
        int[] maxFromRight = new int[len];
        
        minFromLeft[0] = nums.get(0);
        maxFromLeft[0] = nums.get(0);
        minFromRight[len - 1] = nums.get(len - 1);
        maxFromRight[len - 1] = nums.get(len - 1);

        int sumForMin, sumForMax;
        
        sumForMin = nums.get(0);
        sumForMax = nums.get(0);

        // left subarray in [0, i]
        for(int i = 1; i < nums.size() - 1; i++) {
            sumForMax = Math.max(nums.get(i), sumForMax + nums.get(i));
            maxFromLeft[i] = Math.max(maxFromLeft[i - 1], sumForMax);
            
            sumForMin = Math.min(nums.get(i), sumForMin + nums.get(i));
            minFromLeft[i] = Math.min(minFromLeft[i - 1], sumForMin);
        }

        sumForMin = nums.get(len - 1);
        sumForMax = nums.get(len - 1);

        // right subarray in [i, len - 1]
        for(int i = len - 2; i > 0; i--) {
            sumForMax = Math.max(nums.get(i), sumForMax + nums.get(i));
            maxFromRight[i] = Math.max(maxFromRight[i + 1], sumForMax);
            
            sumForMin = Math.min(nums.get(i), sumForMin + nums.get(i));
            minFromRight[i] = Math.min(minFromRight[i + 1], sumForMin);
        }

        int maxDifference = 0;

        for(int i = 0; i < len - 1; i++) {
            int temp1 = maxFromLeft[i] - minFromRight[i + 1];
            temp1 = temp1 < 0 ? - temp1 : temp1;
            int temp2 = maxFromRight[i + 1] - minFromLeft[i];
            temp2 = temp2 < 0 ? - temp2 : temp2;

            maxDifference = Math.max(
                maxDifference,
                Math.max(temp1, temp2)
            );
        }

        return maxDifference;
    }


    // brute force
    // 3210 ms
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


1 2 -3 1

1 3 3 3

