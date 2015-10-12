/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class LevelOrder2 {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     *  2 DFS
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = 
            new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();

        dfsHelper(root, result, 0);

        return result;
    }

    public void dfsHelper(
                    TreeNode node, 
                    ArrayList<ArrayList<Integer>> result,
                    int level) {
        if(node == null) {
            return;
        }

        result.get(level).add(node.val);

        dfsHelper(node.left, result, level + 1);
        dfsHelper(node.right, reuslt, level + 1);
    }
}