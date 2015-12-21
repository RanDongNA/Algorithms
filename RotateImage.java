public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
        	return;
        }

        int rowRange = matrix.length / 2;

        for(int row = 0; row < rowRange; row++) {

        	// index of the last item in this row to be rotated
        	int itemRange = matrix.length - row * 2 - 1;

        	for(int item = 0; item < itemRange; item++) {

        		int temp = matrix[row][row + item];
        		matrix[row][row + item] = matrix[row + itemRange - item][row];
        		matrix[row + itemRange - item][row] = matrix[row + itemRange][row + itemRange - item];
        		matrix[row + itemRange][row + itemRange - item] = matrix[row + item][row + itemRange];
        		matrix[row + item][row + itemRange] = temp;
        	}
        	
        }
    }
}
