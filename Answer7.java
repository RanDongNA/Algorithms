import java.util.*;
import java.math.BigInteger;

public class Answer7 {   
    public static String answer(int x, int y, int n) { 
    	return ""+ getC(x+y-1-1,x-1)
                    .multiply(getFactorial(n-x-y+1))
                    .multiply(getC(n-x-y,x-1+y-1-1));
                // + " = " + getC(x+y-1-1,x-1) 
                // + " * " + getFactorial(n-x-y+1) 
                // + " * " + getC(n-x-y,x-1+y-1-1);
    } 

    public static BigInteger getC(int m,int n) {
    	if(m<=0 || n<=0) return 1;
    	BigInteger result = new BigInteger(""+m);
    	for(int i=m-1;i>m-n;i--) {
            result = result.multiply(new BigInteger(""+i));
            //System.out.println(i);
        }
    	return result.divide(getFactorial(m-n));
    }

    
    public static BigInteger getFactorial(int n) {
    	BigInteger result = new BigInteger("1");
    	for(int i=1;i<=n;i++) {
    		result = result.multiply(new BigInteger(""+i));
    	}
    	return result;
    }

    public static void main(String[] args) {
    	System.out.println(answer(4,3,7));
    }
}