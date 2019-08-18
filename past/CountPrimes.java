public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isGood = new boolean[n];
        
        int count=0;
        for(int i=2; i<n ;i++) { 
            if(isGood[i]) {
                continue;
            }
            count++;
            for(int j=i*i;j<n && (Integer.MAX_VALUE/i)>i ;j+=i) {
                
                isGood[j]=true;
            }
        }
        /*for (int i = 2; i < n; i++) {
            if (!isGood[i]) {
                count++;
                //System.out.print(i+",");
            }
        }*/
        return count;
    }

	public static void main(String[] args) {
        CountPrimes cp =new CountPrimes();
		System.out.println("count: "+cp.countPrimes(499979));
	}
}