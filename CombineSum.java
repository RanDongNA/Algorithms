import java.util.*;

public class CombineSum {
    private List<List<Integer>> result;
    private ArrayList<Integer> item;
    private int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result  = new LinkedList<List<Integer>>();
        
        if(candidates==null||candidates.length==0||target<=0) return result;

        item = new ArrayList<Integer>();
        this.target = target;
        recur(0,candidates,0);

        return result;
    }
    
    public void recur(int num,int[] candidates,int max) {
    	if(num>target) return;

    	if(num<target) {

    		for(int i=0;i<candidates.length;i++) {
    			int thisnum = candidates[i];
    			if(thisnum>=max) {
	    			item.add(candidates[i]);
	    			//System.out.println("add item: "+item);
		    		recur(num+candidates[i],candidates,thisnum);	    	
		    		item.remove(item.size()-1);
		    		//System.out.println("rem item: "+item);
		    	}
	    	}

    	} else {
    		result.add(new ArrayList(item));
    	}


    }

    public static void main(String[] args) {
    	CombineSum c = new CombineSum();
    	System.out.println(c.combinationSum(new int[]{2,3,6,7},7));
    }
}