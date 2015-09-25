public class HappyNumber {
    public boolean isHappy(int n) {
        int memory=n;
		int sum=n;
		while(true) {
			n=sum;
			sum=0;
			while(n>0) {
				System.out.print(n%10+"^2 ");
				sum+=n%10*(n%10);
				n/=10;
			}
			System.out.println(" = "+sum);
			if(sum==1) return true;
			else if(sum==2) return false;
		}
    }
    public static void main(String[] args) {
        int i = 11;
        HappyNumber hn = new HappyNumber();
        System.out.println("if "+i+" is a Happy Number?: "+hn.isHappy(i));
    }
}