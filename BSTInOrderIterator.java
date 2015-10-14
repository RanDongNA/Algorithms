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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    private int index;
    private ArrayList<TreeNode> list;
    
    //@param root: The root of binary tree.
    public Solution(TreeNode root) {
        index = 0;
        list = new ArrayList<TreeNode> ();
        helper(root, list);
    }
    private void helper(TreeNode root, ArrayList<TreeNode> result) {
        if(root == null) {
            return;
        }
        
        helper(root.left, result);
        result.add(root);
        helper(root.right, result);
    }
    //@return: True if there has next node, or false
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        } else {
            return false;
        }
    }
    
    //@return: return next node
    public TreeNode next() {
        if(hasNext()) {
            return list.get(index++);
        } else {
            return null;
        }
    }
}
