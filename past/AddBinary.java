public class AddBinary {
    public String addBinary(String a, String b) {
        //
        String result="";
        boolean evo = false;
        for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--) {
        	System.out.println("\ni: "+i+" j: "+j);

        	char aa = i>=0?a.charAt(i):'0';
        	char bb = j>=0?b.charAt(j):'0';
        	System.out.println(aa+"+"+bb+" evo:"+evo);
        	char next;
        	if(aa==bb) {
        		if(evo) {

        			next='1';
        		} else
        			next='0';

        		if(aa=='1')
        			evo=true;
        		else
        			evo=false;
        	} else {
        		if(evo) {
        			evo = true;
        			next='0';
        		} else {
        			evo = false;
        			next='1';
        		}
        	}
        	System.out.println(next);
        	result = ""+next + result;
        }
        if(evo)
        	result = '1' + result;


        return result;
    }

    public static void main(String[] args) {
    	AddBinary ab = new AddBinary();
    	System.out.println("result:"+ab.addBinary("1010","1011"));
    }
}