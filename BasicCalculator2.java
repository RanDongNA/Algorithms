public class BasicCalculator2 {
    private int index=0;

    public int calculate(String s) {
        String a="",b="";
        int result=0;
        char operator='+';

        for(;index<s.length();index++) {
            char ch=s.charAt(index);
            switch(ch) {
                case '+':
                case '-':
                    if(b.length()>0)
                        result = cal(result,Integer.parseInt(b),operator);
                    operator=ch;
                    b="";
                    break;
                case '*':
                case '/':
                	result = cal(result,calculate(s),operator);
                	break;
                case ' ':
                    break;
                case '(':
                    index++;
                    result = cal(result,calculate(s),operator);
                    break;
                case ')':                    
                    if(b.length()>0)                    
                        result = cal(result,Integer.parseInt(b),operator);
                    return result;
                default:
                    // 0~9
                    b+=ch;
                    break;
            }
        }
        if(b.length()>0)
            result = cal(result,Integer.parseInt(b),operator);
        return result;
    }


    public int cal(int a, int b, char operator) {
        //System.out.println(""+a+" "+operator+" "+b);
        int result=0;
        switch(operator) {
            case '+': result=a+b;break;
            case '-': result=a-b;break;
            case '*': result=a*b;break;
            case '/': result=a/b;break;
            default: break;
        }
        return result;
    }

    public static void main(String[] args) {
    	BasicCalculator bc = new BasicCalculator();
    	System.out.println("output(15): "+bc.calculate("1+3+2*2+5/2*4-3"));
    }
}