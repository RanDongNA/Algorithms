public class Solution {
   /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return true;
        }

        if(dict == null || dict.size() == 0) {
            return false;
        }
        
        int maxLen = 0;
        for(String str : dict) {
            maxLen = Math.max(maxLen, str.length());
        }

        boolean [] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= maxLen && j <= i; j++) {
                String word = s.substring(i - j, i);
                if(f[i - j] == true
                    && dict.contains(word)) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }
}