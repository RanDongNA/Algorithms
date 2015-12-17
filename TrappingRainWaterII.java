public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
    	if(heights == null || heights.length == 0) {
    		return 0;
    	}
    	if(heights[0] == null || heights[0].length == 0) {
    		return 0;
    	}
    	

    	int numberOfRow = heights.length;
    	int numberOfCol = heights[0].length;

    	PriorityQueue<Point> pq = new PriorityQueue<Point>(
    		10,
    		new Comparator<Point>() {
    			public int compare(Point p1, Point p2) {
    				if(p1.level >= p2.level) {
    					return 1;
    				} else {
    					return -1;
    				}
    			}
    		} 
    	);

    	int[][] map = new int[numberOfRow][numberOfCol]; 
    	// 0 for not visited, 1 for currently in queue, -1 for visited and abandonded
    	
    	for(int i = 0; i < numberOfRow; i++) {
    	    pq.add(new Point(i, 0, heights[i][0]));
    	    map[i][0] = 1;
    	    pq.add(new Point(i, numberOfCol - 1, heights[i][numberOfCol - 1]));
    	    map[i][numberOfCol - 1] = 1;
    	}
    	
    	for(int j = 1; j < numberOfCol - 1; j++) {
    	    pq.add(new Point(0, j, heights[0][j]));
    	    map[0][j] = 1;
    	    pq.add(new Point(numberOfRow - 1, j, heights[numberOfRow - 1][j]));
    	    map[numberOfRow - 1][j] = 1;
    	}
    	
    	
 		int result = 0;

 		while(pq.size() > 0) {
 			Point lowest = pq.peek();
 			int x = lowest.x;
 			int y = lowest.y;
 			int level = lowest.level;
 			
 			if(x + 1 < numberOfRow) {
 				// visit bottom
 				result += visit(heights, map, pq, x + 1, y, level);
 			}

			if(x - 1 >= 0) {
				// visit top
				result += visit(heights, map, pq, x - 1, y, level);
 			}

 			if(y - 1 >= 0) {
 				// visit left
 				result += visit(heights, map, pq, x, y - 1, level);
 			}

 			if(y + 1 < numberOfCol) {
 				// visit right
 				result += visit(heights, map, pq, x, y + 1, level);
 			}
            map[x][y] = -1;
 			pq.remove(lowest);			 			
 		} // end of while       

 		return result;
    } // end of trappingWater()

    private int visit(int[][] heights, int[][] map, PriorityQueue<Point> pq, int x, int y, int level) {
    	int result = 0;

    	if(map[x][y] == 0) {
    		int curLevel = heights[x][y];
    		if(curLevel < level) {
    			result = level - curLevel;
    			pq.add(new Point(x, y, level));
    		} else {
    		    pq.add(new Point(x, y,  curLevel));
    		}
            map[x][y] = 1;
    		
    	} 

    	return result;
    }
}

class Point {
	int x;
	int y;
	int level;

	public Point(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
	}
}

