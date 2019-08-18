public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null) {
            return false;
        }

        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();

        boolean[][] f = new boolean[len1 + 1][len2 + 1];

        f[0][0] = true;

        for(int i = 1; i <= len1; i++) {
            f[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1);
        }
        for(int j = 1; j <= len2; j++) {
            f[0][j] = s3.charAt(j - 1) == s2.charAt(j - 1);
        }

        for(int i = 1; i<= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                char thisChar = s3.charAt(i + j - 1);
                if(thisChar == s1.charAt(i - 1)) {
                    f[i][j] = f[i][j] || f[i - 1][j];
                }

                if(thisChar == s2.charAt(j - 1)) {
                    f[i][j] = f[i][j] || f[i][j - 1];
                }
            }
        }

        return f[len1][len2];
    }
}