public class SetZeros {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;

        boolean firstRowHasZero = false;
        boolean thisRowHasZero = false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for(int i=0;i<colLen;i++) {
        	if(matrix[0][i]==0) {
        		firstRowHasZero = true;
        		break;
        	}
        }
        for(int j=1;j<rowLen;j++) {
        	for(int i=0;i<colLen;i++) {
        		if(matrix[j][i]==0) {
        			thisRowHasZero = true;
        			matrix[0][i]=0;
        		}
        	}
        	if(thisRowHasZero) {
        		for(int i=0;i<colLen;i++)
        			matrix[j][i]=0;
        		thisRowHasZero = false;
        	}
        }
        for(int i=0;i<colLen;i++) {
        	if(matrix[0][i]==0) {
        		for(int j=1;j<rowLen;j++) {
        			matrix[j][i] = 0;
        		}
        	}
        }
        if(firstRowHasZero) {
        	for(int i=0;i<colLen;i++) {
        		matrix[0][i] = 0;
        	}
        }
    }
}