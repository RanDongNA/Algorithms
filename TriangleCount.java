public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        if(S == null || S.length == 0) {
            return 0;
        }

        Arrays.sort(S);
        int count = 0;
        int len = S.length;

        for(int i = len - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;

            while(left < right) {
                int sum = S[right] + S[left];
                if(sum > S[i]) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}

