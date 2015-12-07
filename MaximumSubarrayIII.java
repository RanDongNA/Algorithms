public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        
    }
 }


f[start][end]

f[i][j]
f[i - 1][j]
f[i][j - 1]
f[i - 1][j - 1]

-1  4  4  5  5  6
    4  4  5  4  6
      -2  3  3  4
          3  3  4
            -2  3
                3




f[end][k]: sum of [k] subarrays end at [end]

f[end - 1][k]
//f[end][k - 1]: f[end][k] is a new start
f[end - 1][k - 1]: f[end][k]

