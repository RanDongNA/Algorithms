public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < numbers.length; i++) {
            int key = numbers[i];
            if(map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i + 1;
            } else {
                map.put(target - key, i + 1);
            }
        }

        return result;       
    }
}
