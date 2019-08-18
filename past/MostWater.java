public class MostWater {
	public int maxArea(int[] height) {
		int max = 0;
		if(height==null||height.length<=1) return max;

		int index1,index2;
		index1=0;
		index2=height.length-1;

		while(index2>index1) {
			int h1 = height[index1];
			int h2 = height[index2];
			int area = (h1>h2?h2:h1)*(index2-index1);
			System.out.println("area: "+area);
			if(area>max)
				max = area;
			if(h1>=h2)
				index2--;
			else
				index1++;
		}

		return max;
	}

	public static void main(String[] args) {
		MostWater mw = new MostWater();
		System.out.println("max area: "+mw.maxArea(new int[] {3,6,5,2,7,3,5,7,1}));
	}
}