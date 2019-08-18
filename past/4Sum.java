public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */


    // brute force O(n4) time
    // 1575 ms on lintcode
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer>>();
        
        if(numbers == null || numbers.length < 4) {
            return result;
        }
        
        int len = numbers.length;
        Arrays.sort(numbers);

        for(int i = 0; i < len - 3; i++) {
            if(i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for(int j = i + 1; j < len - 2; j++) {
                if(j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                for(int k = j + 1; k < len - 1; k++) {
                    if(k != j + 1 && numbers[k] == numbers[k - 1]) {
                        continue;
                    }
                    for(int l = k + 1; l < len; l++) {
                        if(l != k + 1 && numbers[l] == numbers[l - 1]) {
                            continue;
                        }
                        if(numbers[i] + numbers[j] + numbers[k] 
                            + numbers[l] == target) {
                            ArrayList<Integer> item
                                = new ArrayList<Integer>();
                            item.add(numbers[i]);
                            item.add(numbers[j]);
                            item.add(numbers[k]);
                            item.add(numbers[l]);

                            result.add(item);
                        }
                    } // end for l
                } // end for k
            } // end for j
        } // end for i

        return result;
    }

    // recommandedd solution
    // 2135 ms
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);

        for(int i = 0; i < numbers.length - 1; i++) {
            if(i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            } 

            for(int j = i + 1; j < numbers.length; j++) {
                if(j != i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }

                int twoSumTarget = target - numbers[i] - numbers[j];
                int left = j + 1;
                int right = numbers.length - 1;

                while(left < right) {
                    int twoSum = numbers[left] + numbers[right];
                    if(twoSum < twoSumTarget) {
                        left++;
                    } else if(twoSum > twoSumTarget) {
                        right--;
                    } else {
                        Arraylist<Integer> item
                            = new ArrayList<Integer>();
                        item.add(numbers[i]);
                        item.add(numbers[j]);
                        item.add(numbers[left]);
                        item.add(numbers[right]);
                        result.add(item);

                        left++;
                        while(numbers[left] == numbers[left - 1]) {
                            left++;
                        }

                        right--;
                        while(numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } // end of big if
                } // end of while

            } // end of for j
        } // end of for i

        return result;
    }

    // hashMap solution
    // wrong order
    // 78% on lintcode
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        
        ArrayList<ArrayList<Integer>> result
            = new ArrayList<ArrayList<Integer>>();

        if(numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);

        HashMap<Integer, ArrayList<ArrayList<Integer>>> map
            = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();

        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                ArrayList<Integer> indices
                    = new ArrayList<Integer>();
                indices.add(i);
                indices.add(j);
                if(map.containsKey(sum)) {                    
                    generateItem(result, map.get(sum), indices, numbers);
                }

                if(!map.containsKey(-sum)) {
                    map.put(-sum, new ArrayList<ArrayList<Integer>>());
                }

                map.get(-sum).add(indices);
            }
        }

        return result;
    }

    public void generateItem(ArrayList<ArrayList<Integer>> result,
                             ArrayList<ArrayList<Integer>> list,
                             ArrayList<Integer> item,
                             int[] numbers) {
        list.stream()
            .filter(i -> i.get(1) < item.get(0))
            .forEach(i -> {
                ArrayList<Integer> temp
                    = new ArrayList<Integer>();
                temp.add(numbers[i.get(0)]);
                temp.add(numbers[i.get(1)]);
                temp.add(numbers[item.get(0)]);
                temp.add(numbers[item.get(1)]);
                tryAppendToResult(result, temp);
            });
    }

    public void tryAppendToResult(ArrayList<ArrayList<Integer>> list,
                                     ArrayList<Integer> item) {
        boolean hasDuplication 
            = list.stream()
                  .anyMatch(
                        i -> i.get(0) == item.get(0)
                        && i.get(1) == item.get(1)
                        && i.get(2) == item.get(2)
                        && i.get(3) == item.get(3));
        if(!hasDuplication) {
            list.add(item);
        }
    }
}

