public class Divide2 {
	public int divide(int dividend, int divisor) {
		boolean isPos;
		if((dividend<0&&divisor>0 )||(dividend>0&&divisor<0))
			isPos = false;
		else
			isPos = true;


		int count = 0;
		int factor = 1;
		int target = dividend<0?dividend:-dividend;
		int base = divisor<0?divisor:-divisor;
		int addon = 0;
		int overflowBoundary = Integer.MIN_VALUE>>1; //	-1073741824
		
		if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		if(divisor==0) return Integer.MAX_VALUE;
		if(target>base) return 0;

		while((base<<1)>=target && base>=overflowBoundary) {
			base <<=1;
			factor <<=1;
		}
		//System.out.println("----base: "+base);
		// now |base| <= |target| and |base|*2 >|target|/overflow 
		
		addon+=base;
		count+=factor;

		while(factor>0) {

			// this add will not go beyond dividend, 
			// will not cause overflow
			//System.out.println("addon: "+addon+" base "+base+" target: "+target);
			while(addon+base>=target && Integer.MIN_VALUE-base<=addon) {
				addon+=base;
				count+=factor;

			}
			//System.out.println("addon: "+addon+" count "+count+" base "+base);

			factor>>=1;
			base>>=1;
		}

		return isPos?count:-count;
	}




	public static void main(String[] args) {
    	Divide2 d = new Divide2();
    	System.out.println("1262439062/-629703411 = -2? "+d.divide(1262439062, -629703411));
    	System.out.println("1/2 = 0? "+d.divide(1,2));
    	System.out.println("1/-1 = -1? "+d.divide(1,-1));
    	System.out.println("4/2 = 2? "+d.divide(4,2));
    	System.out.println("10/0 = OF? "+d.divide(10,0));
    	System.out.println("0/0 = OF? "+d.divide(0,0));
    	System.out.println("12/1 = 12? "+d.divide(12,1));
    	System.out.println("13/6 = 2? "+d.divide(13,6));
    	System.out.println("31/8 = 3? "+d.divide(31,8));
    	System.out.println("16/4 = 4? "+d.divide(16,4));
    	System.out.println("2147483647/1 = 2147483647? "+d.divide(2147483647,1));
    	System.out.println("-2147483648/1 = -2147483648? "+d.divide(-2147483648,1));
    	System.out.println("2147483647/2 = 1073741823? "+d.divide(2147483647,2));
    	System.out.println("23/2147483647 = 0? "+d.divide(23,2147483647));
    	System.out.println("2147483647/2147483647 = 1? "+d.divide(2147483647,2147483647));
    	System.out.println("1/-1 = -1? "+d.divide(1,-1));
    	System.out.println("11/-2 = -5? "+d.divide(11,-2));
    	System.out.println("-4/2 = -2? "+d.divide(-4,2));
    	System.out.println("-16/-4 = 4? "+d.divide(-16,-4));
    	System.out.println("-2147483648/2147483647 = -1? "+d.divide(-2147483648,2147483647));
    	System.out.println("-2147483648/-2147483648 = 1? "+d.divide(-2147483648,-2147483648));
    	System.out.println("-2147483648/-1 = OF? "+d.divide(-2147483648,-1));
    }
}