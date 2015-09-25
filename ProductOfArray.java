public class ProductOfArray {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int temp = 1;
        for(int i=0;i<nums.length;i++) {
            if(i==0) 
                output[i]=1;
            else {
                temp *= nums[i-1];
                output[i] = temp;
            }
        }
        temp = 1;
        for(int j=nums.length-2;j>=0;j--) {
            temp *= nums[j+1];
            output[j] *= temp; 
        }
        
        return output;
        
    }

    public static void main(String [] args) {
        ProductOfArray poa = new ProductOfArray();
        int[] result = poa.productExceptSelf(new int[]{1,2,3,4});
    	for(int i : result)
    		System.out.print(" "+i);
    }
}