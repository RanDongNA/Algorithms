/**
 * Definition for a binary tree node.
 */ class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }}
 /* }
 */
public class BinaryTreeMaxPath {
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        if (root==null) return 0;
        int result = cal(root);
        return max>result?max:result;
    }
        
    public int cal(TreeNode root) {

        
        int left = cal(root.left);
        int right = cal(root.right);
        int temp = left>right?left:right;
        int local = left+right+root.val;
        
        if(local>max)
           max = local;

            
        return root.val+temp<0?0:temp;
    }
}