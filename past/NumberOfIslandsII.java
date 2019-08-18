/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(n < 1 || m < 1 || operators == null || operators.length == 0) {
            return result;
        }
        
        int count = 0;
        HashMap<Integer, Integer> rootTable
            = new HashMap<Integer, Integer>();

        for(Point p : operators) {
            count++;
            
            int now = p.x * m + p.y;
            int down = (p.x + 1) * m + p.y;
            int up = (p.x - 1) * m + p.y;
            int left = p.x * m + p.y - 1;
            int right = p.x * m + p.y + 1;
            
            rootTable.put(now, now);
            
            if(p.x + 1 < n && rootTable.containsKey(down) && union(rootTable, now, down)) {
                count--;
            }
            if(p.x - 1 >= 0 && rootTable.containsKey(up) && union(rootTable, now, up)) {
                count--;
            }
            if(p.y + 1 < m && rootTable.containsKey(right) && union(rootTable, now, right)) {
                count--;
            }
            if(p.y - 1 >= 0 && rootTable.containsKey(left) && union(rootTable, now, left)) {
                count--;
            }

            result.add(count);
        }
        
        return result;
    }
    
    // 7347 ms
    private int find(HashMap<Integer, Integer> rootTable, int leaf) {
        int value = rootTable.get(leaf);
        while(value != rootTable.get(value)) {
            value = rootTable.get(value);
        }
        return value;
    }
    
    // 7015 ms
    private int compress_find(HashMap<Integer, Integer> rootTable, int leaf) {
        int value = rootTable.get(leaf);
        while(value != rootTable.get(value)) {
            value = rootTable.get(value);
        }
        
        int pointer = rootTable.get(leaf);
        while(pointer != rootTable.get(pointer)) {
            int next = rootTable.get(pointer);
            rootTable.put(pointer, value);
            pointer = next;
        }
        
        return value;
        
    }

    private boolean union(HashMap<Integer, Integer> rootTable, int point, int neighbor) {
        int rootOfPoint = compress_find(rootTable, point);
        int rootOfNeighbor = compress_find(rootTable, neighbor);
        if(rootOfPoint != rootOfNeighbor) {
            rootTable.put(rootOfPoint, rootOfNeighbor);
            return true;
        } else {
            return false;
        }
    }     
}
