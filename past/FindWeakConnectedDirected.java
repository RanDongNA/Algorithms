/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            
        if(nodes == null || nodes.size() == 0) {
            return result;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // init
        for(DirectedGraphNode node : nodes) {
            map.put(node.label, node.label);
        }
        
        // fill and union
        for(DirectedGraphNode node : nodes) {            
            for(DirectedGraphNode neighbor : node.neighbors) {
                int nodeBoss = find(map, node.label);
                int neighborBoss = find(map, neighbor.label);
                if(nodeBoss != neighborBoss) {
                    union(map, node.label, neighbor.label);
                }
            }
        }

        HashMap<Integer, List<Integer>> resultBuilder
            = new HashMap<Integer, List<Integer>>();

        for(Integer i : map.keySet()) {
            int boss = find(map, map.get(i));
            if(!resultBuilder.containsKey(boss)) {
                List<Integer> temp = new ArrayList<Integer>();
                resultBuilder.put(boss, temp);
            }

            resultBuilder.get(boss).add(i);
        }

        for(Integer i : resultBuilder.keySet()) {
            Collections.sort(resultBuilder.get(i));
            result.add(resultBuilder.get(i));
        }        

        return result;
    }

    // make x the boss of y
    private void union(HashMap<Integer , Integer> table, int x, int y) {
        int fx = find(table, x);
        int fy = find(table, y);
        if(fx != fy) {
            table.put(fx, fy);
        }
    }

    // find the boss of x
    // * make sure x is in table key set
    private int find(HashMap<Integer, Integer> table, int x) {
        int value = table.get(x);
        while(value != table.get(value)) {
            value = table.get(value);
        }        
        return value;
    }
}
