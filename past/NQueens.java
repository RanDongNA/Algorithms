import java.util.*;
public class NQueens {
    List<List<String>> result;
    char[][] solution;
    int bigN;

    public List<List<String>> solveNQueens(int n) {
    	result = new ArrayList<List<String>>();
    	bigN = n;
    	solution = new char[bigN][bigN];
    	for(int i=0;i<bigN;i++)
    		for(int j=0;j<bigN;j++)
    			solution[i][j]='.';
        //print();
    	
        for(int i=0;i<bigN;i++)
        	dfs(i,0);
        //System.out.println(result);
    	return result;

    }


    // solution.get();
    // solution

    public void dfs(int row, int col) {
        //System.out.println("dfs("+row+", "+col+") called");
        // solution[row][col] = 'Q';
        // print();
        // solution[row][col] = '.';

    	boolean valid = exam(row,col);    	
    	
    	if(!valid) 
    		return;
    	else if(col==bigN-1) {
    		solution[row][col] = 'Q';
    		save();
    		solution[row][col] = '.';
    		return;
    	} else {
    		solution[row][col] = 'Q';
	    	for(int i=0;i<bigN;i++) {
	    		dfs(i,col+1);
	    	}
	    	solution[row][col] = '.';
	    }
    	
    }

    public boolean exam(int row, int col) {
        // System.out.println("exam() called");
    	int[] xOffset = new int[] {-1,-1,-1,0,0,1,1,1};
    	int[] yOffset = new int[] {1,-1,0,1,-1,-1,1,0};
    	
    	for(int i=0;i<=7;i++) {
    		int x=row;
    		int y=col;
    		while(x>=0 && x<bigN && y>=0 && y<bigN) {
    			if(solution[x][y]=='Q')
    				return false;
    			x+=xOffset[i];
    			y+=yOffset[i];
    		}
    	}

    	return true;
    }

    public void save() {
        //System.out.println("save() called");
    	List<String> item = new ArrayList<String>();
    	
    	for(int i=0;i<bigN;i++) {
    		String row = "";
    		for(int j=0;j<bigN;j++) {
    			row += solution[i][j];
    		}
    		item.add(row);
    	}

    	result.add(item);
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.solveNQueens(4);
        
    }

    public void print() {
        for(char[] row:solution) {
    		for(char ch:row)
    			System.out.print(ch);
            System.out.println();
        }
    }
}