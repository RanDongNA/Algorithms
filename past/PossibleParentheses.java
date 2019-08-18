public class PossibleParentheses {
	
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<input.length();i++) {
        	char operator = input.charAt(i);
        	if(operator=='+'||operator=='-'||operator=='*') {
        		List<Integer> left = diffWaysToCompute(input.substring(0,i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1));

        		for(int j=0;j<left.size();j++) {
        			for(int k=0;k<right.size();k++) {
        				result.add(cal(left.get(j),right.get(k),operator));
        			}
        		}
        	}
        }
        if(result.size()==0) {
        	result.add(Integer.parseInt(input));
        }
        return result;
    }
	
    public int cal(int a,int b, char op) {
		int result=0;

		switch(op) {
			case "+": result = a+b; break;
			case "-": result = a-b; break;
			case "*": result = a*b; break;
			default: break;
		}
		return result;
	}

}