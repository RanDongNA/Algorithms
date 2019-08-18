public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    // Time Limit Exceeded
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return result;
        }

        int len = nums.length;
        int[] sums = new int[len];
        int diff = nums[0] >= 0 ? nums[0] : - nums[0];
        int start = 0;
        int end = 0;

        sums[0] = nums[0];

        for(int row = 0; row < len; row++) {
            
            for(int col = row; col < len; col++) {
                if(col == row) {
                    sums[col] = nums[col];   
                } else if(col != row) {
                    sums[col] = sums[col - 1] + nums[col];
                }
                int abs = sums[col] >= 0 ? sums[col] : - sums[col];

                if(abs < diff) {
                    diff = abs;
                    start = row;
                    end = col;
                }
                
                if(diff == 0) {
                    row = len;
                    col = len;
                }
            }
        }

        result.add(start);
        result.add(end);

        return result;
    }

    // Accepted Solution
    class Pair {
        int sum;
        int index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        int len = nums.length;

        if(len == 1) {
            result.add(0);
            result.add(0);
            return result;
        }

        Pair[] sums = new Pair[len];
        sums[0] = new Pair(nums[0], 0);

        for(int i = 1; i < len; i++) {
            sums[i] = new Pair(nums[i] + sums[i - 1].sum, i);
        }

        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if(a.sum == b.sum) {
                    return a.index - b.index;
                } else {
                    return a.sum - b.sum;
                }
            }
        });

        int start = 0,end = 0;
        int diff = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++) {
            int temp = sums[i].sum - sums[i - 1].sum;
            if(temp < diff) {
                diff = temp;
                int index1 = sums[i - 1].index;
                int index2 = sums[i].index;
                start = index1 < index2 ? index1 + 1 : index2 + 1;
                end = index1 < index2 ? index2 : index1;
                
            }

            if(diff == 0) {
                break;
            }
        }

        result.add(start);
        result.add(end);
        return result;
    }
}