public class MoveZeros {
	public void moveZeroes(int[] nums) {
		if(nums==null||nums.length<=1) 
			return;
		int index = 0;
		int checkIndex = 0;

		for(;checkIndex<nums.length;checkIndex++) {
			if(nums[checkIndex]!=0) {
				if(checkIndex!=index) {
					int temp = nums[index];
					nums[index]=nums[checkIndex];
					nums[checkIndex]=temp;
		
				}
				index++; 
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] {0,1,0,3,12};
		int[] aa = new int[] {}
		MoveZeros mz = new MoveZeros();
		mz.moveZeroes(a);
		for(int b:a) {
			System.out.print(" "+b);
		}
	}
}