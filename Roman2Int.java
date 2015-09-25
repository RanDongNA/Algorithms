public class Roman2Int {
    public int romanToInt(String s) {
    	if(s==null || s.length()==0) return 0;
    	char[] romans = new char[] {'M','D','C','L','X','V','I'};
        int[] values = new int[] {1000,500,100,50,10,5,1};

    	int[] temp = new int[s.length()];

    	for(int i=0;i<s.length();i++) {
    		char  digit = s.charAt(i);
    		for(int j=0;j<=6;j++) {
    			if(digit==romans[j]) {
    				temp[i] = values[j];
    			}
    		}
    	}
    	int result =0;
    	for(int i=0;i<s.length()-1;i++) {
    		if(temp[i]<temp[i+1]) {
    			result -= temp[i];
    		} else 
    			result += temp[i];

    	}
    	result += temp[s.length()-1];
        return result;
    }
}