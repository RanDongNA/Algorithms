public class Int2Words {
    public String numberToWords(int num) {
        if(num == 0) 
            return "Zero";

        StringBuilder sb = new StringBuilder();
        
        int part = num % 1000;
        sb.append(helper(part));

        for(int i = 1; i < 5; i++) {
            num = num / 1000;
            part = num % 1000;
            if(part != 0) 
                sb.insert(0,(helper(part) + thousands[i]) + " ");
        }

        return sb.toString();
    }

    String[] ones = new String[]{"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] teens = new String[] {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tys = new String[]{"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = new String[] {"","Thousand","Million","Billion","Trillion"};

    public String helper(int num) {
        
        StringBuilder result = new StringBuilder();
        
        int hundred = num / 100;
        int ten = num % 100 / 10;
        int one = num % 10;

        if(hundred != 0) {
            result.append(ones[hundred] + " " + "Hundred" + " ");
        }

        
        if(ten != 1) {
            if(ten > 1)
                result.append(tys[ten] + " ");
            if(one != 0)
            result.append(ones[one] + " ");
        } else if(ten == 1) {
            result.append(teens[one] + " ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Int2Words i2w = new Int2Words();
        //System.out.println(i2w.helper(227));
        System.out.println(i2w.numberToWords(12150234));
        System.out.println(i2w.numberToWords(1234567));
        
    }
}