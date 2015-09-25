import java.util.*;

public class FindPermutation{
	
	private List<List<Integer>> result;
	private boolean[] isVisited;
	private List<Integer> item;
	private int[] numbers;

	//public void recursionl
	public void recur() {
		for(int i=0;i<numbers.length;i++) {

			if(!isVisited[i]) {
				System.out.println(item);
				item.add(numbers[i]);
				isVisited[i]=true;
				if(item.size()==numbers.length) {
					result.add(new ArrayList<Integer>(item));
				}
				recur();
				isVisited[i]=false;
				item.remove(item.size()-1);
			}
		}

	}

`
	public List<List<Integer>> permute(int[] nums) {
		//init
		numbers = new int[nums.length];
		for(int i=0;i<nums.length;i++) numbers[i] = nums[i]; 
		result = new ArrayList<List<Integer>>();		
		item = new ArrayList<Integer>();
		isVisited = new boolean[nums.length];
		for(boolean b:isVisited) { b= false; }

		recur();

		return result;
	}

	public static void main(String[] args) {
		FindPermutation fp = new FindPermutation();

		System.out.println(fp.permute(new int[] {}));
	}
}