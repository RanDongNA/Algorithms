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
public class SearchRangeInBST {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrderHelper(root, k1, k2, result);
        return result;
    }
    
    public void inOrderHelper(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        
        if(root.val >= k1) {
            inOrderHelper(root.left, k1, k2, result);
        }
        
        if(root.val <= k2 && root.val >= k1) {
            result.add(root.val);
        }
        
        
        if(root.val <= k2) {
            inOrderHelper(root.right, k1 ,k2, result);
        }
    }
}