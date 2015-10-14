public class JumpGame {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if(A == null || A.length == 0) {
            return true;
        }

        int len = A.length;
        boolean [] f = new boolean[len];
        f[0] = true;

        for(int i = 1; i < len; i++) {
            for(int j = 1; j <= i; j++) {
                if(f[i - j] == true && A[i - j] >= j) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[len - 1];
    }
}


