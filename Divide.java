import java.util.*;

public class Divide {

    public int divide(int dividend, int divisor) {

    	boolean isPos;
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
      		isPos = true;
      	else
      		isPos = false;

        int count = 0;
        int factor = -1;

        int base = divisor<0?divisor:-divisor;
        int addon = 0;

        int target = dividend<0?dividend:-dividend;
        
        int overflowBoundary = Integer.MIN_VALUE>>1;
      	

      	//System.out.println("factor: "+factor+" base: "+base+" target: "+target+" pos?: "+isPos);
      	if(base==0) return Integer.MAX_VALUE;
      	if(target==0) return 0;
      	if(target>base) return 0;
      	if(base==target) return isPos?1:-1;
        if(base==target>>1) return isPos?2:-2;
        if(base<overflowBoundary) return isPos?1:-1;
        
        // so that when the loop ends, either
        // 1. base is larger than dividend
        // 2. double the base will cause overflow
        while(base>target) {
        	if((base<<1)<overflowBoundary)
        		break;      	
        	base<<=1;
        	factor<<=1;
        }

        //System.out.println("after while:\n  base: "+base+" target: "+target+" facotr: "+factor);
        // let's /2 first
        base>>=1;
        factor>>=1;

        // count once
        count += factor;
        addon += base;
        //System.out.println(addon+" "+count);

        // if anthing else to add up
        int boundary = divisor<0?divisor:-divisor;
        while(base<boundary) {
        	
        	factor>>=1;
        	base>>=1;
        	//System.out.println("in while:\n  base: "+base+" facotr: "+factor);
        	// check if this add up will cause overflow
        	while(addon+(base-addon)/2>=overflowBoundary && addon+base>=target) {
        		//System.out.println("base: "+base);
        		addon+=base;
        		count+=factor;
        		//System.out.println(addon+" "+count);
        	}
        	// if(count==Integer.MIN_VALUE)
        	// 	return Integer.MAX_VALUE;
        }
        if(isPos&&count==Integer.MIN_VALUE)
        	return Integer.MAX_VALUE;
    	return isPos?-count:count;
    }


    public static void main(String[] args) {
    	Divide d = new Divide();
    	System.out.println("1262439062/-629703411 = "+d.divide(1262439062, -629703411));
    	// System.out.println("1/2 = "+d.divide(1,2));
    	// System.out.println("1/-1 = "+d.divide(1,-1));
    	// System.out.println("4/2 = "+d.divide(4,2));
    	// System.out.println("10/5 = "+d.divide(10,5));
    	// System.out.println("10/0 = "+d.divide(10,0));
    	// System.out.println("0/0 = "+d.divide(0,0));
    	// System.out.println("12/1 = "+d.divide(12,1));
    	// System.out.println("13/6 = "+d.divide(13,6));
    	// System.out.println("31/8 = "+d.divide(31,8));
    	// System.out.println("16/4 = "+d.divide(16,4));
    	// System.out.println("2147483647/1 = "+d.divide(2147483647,1));
    	// System.out.println("-2147483648/1 = "+d.divide(-2147483648,1));
    	// System.out.println("2147483647/2 = "+d.divide(2147483647,2));
    	// System.out.println("23/2147483647 = "+d.divide(23,2147483647));
    	// System.out.println("2147483647/2147483647 = "+d.divide(2147483647,2147483647));
    	// System.out.println("1/-1 = "+d.divide(1,-1));
    	// System.out.println("11/-2 = "+d.divide(11,-2));
    	// System.out.println("-4/2 = "+d.divide(-4,2));
    	// System.out.println("-16/-4 = "+d.divide(-16,-4));
    	// System.out.println("-2147483648/2147483647 = "+d.divide(-2147483648,2147483647));
    	// System.out.println("-2147483648/-2147483648 = "+d.divide(-2147483648,-2147483648));
    	// System.out.println("-2147483648/-1 = "+d.divide(-2147483648,-1));
    }
}