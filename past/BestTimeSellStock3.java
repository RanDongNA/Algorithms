import java.util.ArrayList;
class BestTimeSellStock3 
{
	public static void main(String[] args) 
	{
		int[] prices = {5,6,7,10,3,1,0,2,4,8,6,5,5};
		System.out.println("\nmax profit: "+(new BestTimeSellStock3()).maxProfit(prices));
	}
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2) return 0;

		int[] pp = new int[prices.length]; //pp for point profit
		pp[0]=0;
		for(int i=1;i<prices.length;i++) {
			pp[i]=prices[i]-prices[i-1];
		}

		int sum,minsum=0,start,minstart=0,minend=prices.length-1;
		sum=0;
		start=0;
		
		for(int end=0;end<prices.length;end++) {

			if(pp[end]>0) {
				if(sum<minsum) {
					minsum=sum;
					minstart=start;
					minend=end;
				}
				sum=0;
				start=end;
				continue;
			}
			sum+=pp[end];
		}
		
		for(int i:pp)
			System.out.print(" "+i);
		System.out.print("\nminstart: "+minstart+" minend: "+minend+" minsum: "+minsum);
		return 0;
	}
}
