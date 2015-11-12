/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(
        ArrayList<UndirectedGraphNode> nodes
    ) {
        List<List<Integer>> result 
            = new ArrayList<List<Integer>>();

        if(nodes == null || nodes.size() == 0) {
            return result;
        }

        HashSet<UndirectedGraphNode> visited
            = new HashSet<UndirectedGraphNode>();

        for(UndirectedGraphNode node : nodes) {
            if(!visited.contains(node)) {
                bfs(node, result, visited);
            }
        }

        return result;
    }

    private void bfs(
        UndirectedGraphNode startNode, 
        List<List<Integer>> result,
        HashSet<UndirectedGraphNode> visited) {

        List<Integer> connectedNodes = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue
            = new LinkedList<UndirectedGraphNode>();

        queue.add(startNode);
        visited.add(startNode);

        while(!queue.isEmpty()) {
            UndirectedGraphNode temp = queue.poll();
            connectedNodes.add(temp.label);
            for(UndirectedGraphNode oneInNeighbors : temp.neighbors) {
                if(!visited.contains(oneInNeighbors)) {
                    queue.add(oneInNeighbors);
                    visited.add(oneInNeighbors);
                }
            }
        }
        Collections.sort(connectedNodes);
        result.add(connectedNodes);
    }
}
