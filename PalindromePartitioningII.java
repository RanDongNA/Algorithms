public class PalindromePartitioningII {
    Boolean[][] isPalindrome;

    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        this.isPalindrome = new Boolean[len][len];
        
        for(int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
            if(i + 1 < len && s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i+1] = true;
            }
        }

        // f[x] means minimum cut needed to make every patition a palindrome
        int[] f = new int[len + 1];
        f[0] = -1;
        int min = Integer.MAX_VALUE;

        for(int i = 1; i <= len; i++) { 
            // i means we are calculating f[i]
            // which is the i th element in String
            // whose index in String is actully i - 1;
            f[i] = Integer.MAX_VALUE;
            for(int j = i - 1; j >= 0; j--) {
                // j means a | after index j in s
                if(getPalindrome(s, j, i - 1)) { // 0 ~ i - 1
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }

        return f[len];
    }

    public boolean getPalindrome(String s,int start, int end) {
        if(end < start) {
            return true;
        }

        boolean result = false;

        if(isPalindrome[start][end] == null) {
            isPalindrome[start][end] = 
                s.charAt(start) == s.charAt(end) 
                && getPalindrome(s, start + 1, end - 1);
        }
        return isPalindrome[start][end];
    }

    public static void main(String[] args) {
        PalindromePartitioningII p = new PalindromePartitioningII();
        System.out.println("leet");
        System.out.println(p.minCut("leet"));
    }
}