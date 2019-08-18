import java.util.List;
import java.util.ArrayList;

// this could be marked as an template for questions like
// combinations, permutations, or something related to DFS, Backtrackint
// this is a recursive solution, can i write a iterative one?
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        
        // declare the Lists
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();

        // if the parameters are valid, run algorithm
        // if not, result will be left null
        if(k>0 && k <= n) 
            dfsHelper(result, item, 0, n, k);

        return result;

    }

    public void dfsHelper(
        List<List<Integer>> result, 
        List<Integer> item, 
        int number,
        int n,
        int k) {

        // the condition where a trial ends
        if(item.size()==k) {
            result.add(new ArrayList<Integer>(item));
            return;
        }

        // try and step back
        // another condition where one trial ends
        //      -> i > n
        for(int i = number + 1; i <= n; i++) {
            item.add(i);
            dfsHelper(result,item,i,n,k);
            item.remove(item.size()-1);
        }

        return;
    }

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(4,2));
        System.out.println(c.combine(2,4));
        System.out.println(c.combine(0,4));
        System.out.println(c.combine(2,0));
        System.out.println(c.combine(2,-1));
        System.out.println(c.combine(-2,4));
    }
}