public class Answer6 {
    public static int answer(int n) { 
		int[] squares = new int[(int)Math.sqrt(n)+1];
		
		for(int i=0;i<squares.length;i++) {
			squares[i] = i*i;
		}

		int[] counts = new int[n+1];

		counts[0] = 0;
		counts[1] = 1;

		for(int i=2;i<=n;i++) {
			int min=Integer.MAX_VALUE;

			int max = (int)Math.sqrt(i);
			if(max*max==i) {
				counts[i] = 1;
				continue;
			}
			
			for(int j=1;j<=i/2;j++) {
				int pair = counts[j]+counts[i-j];
				min = pair<min?pair:min;
			}

			counts[i] = min;
		}
		return counts[n];
	}
}