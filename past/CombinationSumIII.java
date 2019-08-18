public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(n < (1 + k) * k / 2 || n > 45) {
        	return result;
        }
        
        for(int i = 1; i <= 10 - k; i++) {
            List<Integer> item = new ArrayList<Integer>();
            helper(result, item, k, n, i);
        }
        
        return result;
    }

    private void helper(
    	List<List<Integer>> result, 
    	List<Integer> item, 
    	int k,
    	int target, 
    	int nextNumber) {

    	if(k == 0) {
    		return;
    	}

    	if(target < nextNumber) {
    		return;
    	}

    	item.add(nextNumber);
        
    	if(k == 1 && target == nextNumber) {
    		result.add(new ArrayList<Integer>(item));
    		item.remove(item.size() - 1);
    		return;
    	}

    	for(int i = nextNumber + 1; i < 10; i++) {
    		helper(result, item, k - 1, target - nextNumber, i);
    	}

    	item.remove(item.size() - 1);
    	
    }
}