public class BalancedBinaryTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if(helper(root) != -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if(left == -1 || right == -1) {
            return -1;
        } else if(left - right <= 1 && left - right >= -1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
