public class Dungeon {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0) return 0;
        int row = dungeon.length-1;
        int col = dungeon[0].length-1;
        int[][] hpNeeded = new int[row+1][col+1];
        //System.out.println("start: "+dungeon[row][col]);
        hpNeeded[row][col] = (dungeon[row][col])>0?1:(1-dungeon[row][col]);
        //System.out.println("start: "+hpNeeded[row][col]);
        for(int i=row;i>=0;i--) {
            for(int j=col;j>=0;j--) {
                if(i==row && j==col) {
                    continue;
                } else {
                    int bottom = i<row?(hpNeeded[i+1][j]>=0?hpNeeded[i+1][j]:0):Integer.MAX_VALUE;
                    int right = j<col?(hpNeeded[i][j+1]>=0?hpNeeded[i][j+1]:0):Integer.MAX_VALUE;
                    hpNeeded[i][j] = (bottom<right?bottom:right) - dungeon[i][j];
                    if(hpNeeded[i][j]==0) hpNeeded[i][j]++;
                    System.out.println(bottom+" "+right+" "+hpNeeded[i][j]);
                }
            }
        }
        for(int i=0;i<=row;i++) {
            for(int j=0;j<=col;j++) {
                System.out.print(hpNeeded[i][j]+" \t");
            }
            System.out.println();
        }
        return hpNeeded[0][0]>0?hpNeeded[0][0]:1;

    }

    public static void main(String[] args) {
    	Dungeon d = new Dungeon();
    	//int[][] dmap = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        //int[][] dmap = new int[][] {{1,-4,5,-99},{2,-2,-2,-1}};
        //int[][] dmap = new int[][] { {-1,1} };
        int[][]dmap = new int[][] {{1,2}};
    	System.out.println("\nmin hp: "+d.calculateMinimumHP(dmap));
    }
}