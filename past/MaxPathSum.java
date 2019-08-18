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
public class MaxPathSum {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.pathMax;
    }

    public ResultType helper(TreeNode root) {
        ResultType result = new ResultType(0, Integer.MIN_VALUE);

        if(root == null) {
            return result;
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        result.pathMax = Math.max(
                            Math.max(left.pathMax, right.pathMax),
                            Math.max(left.oneMax,0) 
                                + Math.max(right.oneMax,0) 
                                + root.val);
        result.oneMax = Math.max(
                            Math.max(root.val, root.val + left.oneMax),
                            root.val + right.oneMax);

        return result;
    }

    public class ResultType {
        int oneMax;
        int pathMax;

        public ResultType(int one, int two) {
            this.oneMax = one;
            this.pathMax = two;
        }
    }
}
