public class Int2Roman {
    public String intToRoman(int num) {
        char[] romans = new char[] {'M','D','C','L','X','V','I'};
        int[] values = new int[] {1000,500,100,50,10,5,1};
        String result="";
        int remain = num;
        int ri = 0; 
        while(num>=0 && ri<=6) {
        	//System.out.println("ri: "+ ri + " result= "+result);
        	if(remain>=values[ri]) {
        		result+=romans[ri];
                remain-=values[ri];
        	} else if(ri+1<=6 && ri%2==1 && remain + values[ri+1]>=values[ri]) {
                result= result + romans[ri+1] + romans[ri];
                remain-=values[ri]-values[ri+1];
            } else if(ri+2<=6 && remain + values[ri+2]>=values[ri]) {
                result= result + romans[ri+2] + romans[ri];
                remain-=values[ri]-values[ri+2];
            } else {
        		ri++;
        	}
        }
        return result;
    }

    public static void main(String[] args) {
    	Int2Roman i = new Int2Roman();
    	for(int j=0;j<=3999;j++)
            System.out.println(j+" ->Roman:"+i.intToRoman(j));
    }
}