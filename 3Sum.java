public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length < 3) {
            return null;
        }

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 2; i++) {
            if(i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int leftPtr = i + 1;
            int rightPtr = numbers.length - 1;

            while(leftPtr < rightPtr) {
                int sum = numbers[leftPtr] + numbers[rightPtr] + numbers[i];
                
                if(sum == 0) {
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(numbers[i]);
                    item.add(numbers[leftPtr]);
                    item.add(numbers[rightPtr]);
                    result.add(item);

                    leftPtr++;
                    rightPtr--;
                    while(leftPtr < rightPtr 
                        && numbers[leftPtr] == numbers[leftPtr - 1]) {
                        leftPtr++;
                    }
                    while(leftPtr < rightPtr
                        && numbers[rightPtr] == numbers[rightPtr + 1]) {
                        rightPtr--;
                    }
                } else if(sum < 0) {
                    leftPtr++;
                } else {
                    rightPtr--;
                }
            }
        }

        return result;
    }

    // rewrite
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 2; i++) {
            if(i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = numbers.length - 1;

            while(left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];

                if(sum == 0) {
                    ArrayList<Integer> item
                        = new ArrayList<Integer>();

                    item.add(numbers[i]);
                    item.add(numbers[left]);
                    item.add(numbers[right]);
                    result.add(item);

                    left++;
                    right--;
                    while(left < right && numbers[left] == number[left - 1]) {
                        left++;
                    }
                    while(left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }    
}
