public class Solution {
    public List<Integer> grayCode(int n) {
        if(n < 0) {
        	return null;
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        if(n == 0) {
            result.add(0);
            return result;
        }
        int finishSize = (int) (Math.pow(2, n));
        
        helper(result, 0, finishSize, n);

        return result;
    }

    private boolean helper(
    	List<Integer> result, 
    	int nextNumber, 
    	int finishSize,
    	int n) {

    	if(result.contains(nextNumber)) {
    		return false;
    	}

    	result.add(nextNumber);

    	if(result.size() == finishSize) {
    		return true;
    	}

    	int temp = 1;

    	for(int i = 1; i <= n; i++) {
    		int orCandidate = nextNumber | temp;
    		int andCandidate = nextNumber & (~temp);
    		boolean flag = false;

    		if(orCandidate == nextNumber) {
    			flag = helper(result, andCandidate, finishSize, n);
    		} else {
    			flag = helper(result, orCandidate, finishSize, n);
    		}

    		if(flag) {
    			return true;
    		}
    		
    		temp = temp << 1;
    	}

    	result.remove(result.size() - 1);

    	return false;

    }
}