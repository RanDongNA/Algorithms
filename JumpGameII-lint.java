public class JumpGameII {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if(A == null || A.length <= 1) {
            return 0;
        }

        int len = A.length;
        int [] f = new int[len];
        f[0] = 0;

        for(int i = 1; i < len; i++) {
            f[i] = Integer.MAX_VALUE;
            for(int j = 1; j <= i; j++) {
                if(f[i - j] != Integer.MAX_VALUE && A[i - j] >= j) {
                    f[i] = Math.min(f[i], f[i - j]);
                }
            }
            f[i]++;
        }

        return f[len - 1];
    }
}