public class CountAndSay {
	public String countAndSay(int n) {
		if(n<=0) return ""+n;
		if(n==1) return "1";
		String result="";
		String mem = ""+1;
		// for the nth string
		for(int i=1;i<n;i++) {
			System.out.println("mem:"+mem);
			// for count and say
			char ch= mem.charAt(0);
			int count=1;
			for(int j=1;j<mem.length();j++) {
				char num = mem.charAt(j);
				
				
				if(num==ch) {
					// same char
					count++

				} else {
					// new num occur
					result = result + count + ch;
					count=1;
					ch=num;
				}
				
			}
			result = result + count + ch;

			System.out.println(i+":"+result);
			mem = result;
			result="";

		}

		return mem;
	}

	public static void main(String[] args) {
		CountAndSay ca = new CountAndSay();
		ca.countAndSay(3);
	}
}