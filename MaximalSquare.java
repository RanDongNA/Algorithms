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
        int [][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for(int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        // filling the chart
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j< matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                } else {
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

        // if all it can find in the chart is only 0
        // check the edge to see if there is any 1
        if(max == 0) {
            for(int i = 0; i < matrix[0].length; i++) {
                if(matrix[0][i] == '1') {
                    return 1;
                }
            }
            for(int i = 0; i < matrix.length; i++) {
                if(matrix[i][0] == '1') {
                    return 1;
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