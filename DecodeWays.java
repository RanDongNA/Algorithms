 public class DecodeWays {
    public int numDecodings(String s) {
        int l = s.length();
        int[] counts = new int[l+1];
       	
        counts[1] = 1;
        counts[2] = 1;

        for(int i=1;i<=l;i++) {
        	int plus = counts[i];
        	char curr = s.charAt(i-1+1);

        	if(i+1<=l) {        		
        		counts[i+1] +=plus;
        	}
        	if(i+2<=l) {
                
        		if(curr-'2'<0) {
                    counts[i+2] +=plus;
        		} else if(curr=='2') {
                    if(s.charAt(i+1)-'7'<0) {
                        counts[i+2] +=plus;
        			}
        		}         		
        	}
        }
        for(int i=0;i<counts.length;i++) System.out.print(counts[i]);
        return counts[l];
    }

    public static void main(String [] args) {
    	DecodeWays dw = new DecodeWays();
    	String str = "12";
    	System.out.println("\n"+str+" : "+dw.numDecodings("125555"));

    }
}