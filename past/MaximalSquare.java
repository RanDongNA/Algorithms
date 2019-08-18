public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        
        // Corner cases
        if(matrix == null || matrix.length ==0) {
            return 0;
        } else if(matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // init
        int max = 0;
        int [][] dp = new int[matrix.length + 1][matrix[0].length + 1];

        // filling the chart
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j< dp[0].length; j++) {
                if(matrix[i - 1][j - 1] == '1') {
                    int area = 1 + min(dp[i - 1][j - 1],
                                       dp[i][j - 1],
                                       dp[i - 1][j]);
                    dp[i][j] = area;
                    
                    if(area > max) {
                        max = area;
                    }
                }
            }
        }
        return max * max;
    }

    public int min(int... a) {
        int min = Integer.MAX_VALUE;
        for(int i : a) {
            if(i < min) {
                min = i;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        char[][] testCase1 = new char[][] {{'0', '1'},{'0', '1'}};
        System.out.println(""+ms.maximalSquare(testCase1));
    }
}


// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0