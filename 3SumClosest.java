public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */

    // O(n3) time, O(1) space
    public int threeSumClosest(int[] numbers ,int target) {
        int len = numbers.length;
        int result = numbers[0] + numbers[1] + numbers[2];
        int curDiff = target - result >= 0 ? 
            target - result : result - target;
        for(int i = 0; i < len - 2; i++) {
            for(int j = i + 1; j < len - 1; j++) {
                for(int k = j + 1; k < len; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    int diff = target - diff;
                    diff = diff >= 0 ? diff : -diff;
                    if(diff < curDiff) {
                        curDiff = diff;
                        result = sum;
                    }
                }
            }
        }

        return result;        
    }


    public int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);

        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;

            while(left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                int diff = sum - target >= 0 ? sum - target : target - sum;
                
                if(diff < minDiff) {
                    minDiff = diff;
                    result = sum;
                }

                if(sum == target) {
                    return sum;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
                 
            }

        }

        return result;
    }


}

