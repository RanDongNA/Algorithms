import java.util.HashMap;
public class IsIsomorphic {
    public static void main(String[] args) {
        IsIsomorphic ii = new IsIsomorphic();
        System.out.println(ii.isIsomorphic("ab","aa"));
    }
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm = new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++) {
            if(!hm.containsKey(s.charAt(i)) && hm.containsValue(t.charAt(i)))
                return false;
            Character ch = hm.put(s.charAt(i),t.charAt(i));
            if(ch!=null && ch!=t.charAt(i))
                    return false;
        }
        return true;
    }
}