import java.util.HashMap;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        int patternLen = pattern.length();
        int strLen = str.length();

        if(patternLen == 0 && strLen == 0) {
            return true;
        } else if(patternLen == 0 || strLen == 0) {
            return false;
        }

        HashMap<Character, String> map = new HashMap<Character, String>();
        HashMap<String, Character> reverseMap = new HashMap<String, Character>();

        int start = 0, end = 1;

        for(int i = 0; i < patternLen; i++) {
            
            char a = pattern.charAt(i);
            
            end = str.indexOf(" ", start + 1);
            
            String word ;
            if(end == -1 && i == patternLen - 1) {
                word = str.substring(start);
            } else if(end != -1 && i != patternLen -1){
                word = str.substring(start, end);
            } else {
                return false;
            }

            String prevStr = map.put(a, word);
            if(prevStr != null && !prevStr.equals(word)) {
                return false;
            }

            Character prevC = reverseMap.put(word, a);
            if(prevC != null && prevC != a) {
                return false;
            }

            start = end + 1;
        }

        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        WordPattern wp = new WordPattern();
        System.out.println(""+wp.wordPattern(pattern, str));
    }
}