import java.util.*;
public class ParenthesisGen {
    private List<String> result;
    private char[] item;
    private int countL=0,countR=0;

    public List<String> generateParenthesis(int n) {
		result = new ArrayList<String>();
		item = new char[n*2];

		recur(0,'(',n);

		return result;
    }

    public void recur(int index, char ch, int n) {
    	item[index] = ch;
    	// for(char c:item) {
    	// 	System.out.print(c);
    	// }
    	// System.out.println();
    	if(index==n*2-1) result.add(new String(item));
    	if(ch=='(') countL++;
    	else countR++;
    	if(countL<n) {
    		recur(index+1,'(',n);
    		countL--;
    	}
    	if(countR<n && countR<countL) {
    		recur(index+1,')',n);
    		countR--;
    	}
    }

    public static void main(String[] args) {
    	ParenthesisGen pg = new ParenthesisGen();
    	System.out.println(pg.generateParenthesis(4));
    }
}

//"((()))", "(()())", "(())()", "()(())", "()()()"