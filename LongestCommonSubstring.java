public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        if(A == null || B == null) {
            return -1;
        }

        int aLen = A.length();
        int bLen = B.length();
        int max = 0;

        int[][] f = new int[aLen + 1][bLen + 1];
        for(int i = 0; i <= aLen; i++) {
            f[i][0] = 0;
        }
        for(int i = 0; i <= bLen; i++) {
            f[0][i] = 0;
        }

        for(int i = 1; i <= aLen; i++) {
            for(int j = 1; j <= bLen; j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    max = Math.max(max, f[i][j]);
                } else {
                    f[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.longestCommonSubstring("ABCD", "EBCE"));
    }
}