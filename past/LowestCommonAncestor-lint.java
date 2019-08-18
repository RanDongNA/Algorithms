public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        return helper(root, A, B);
    }

    public TreeNode helper(TreeNode root, TreeNode a, TreeNode b) {
        
        if(root == null) {
            return null;
        }

        TreeNode left = helper(root.left, a, b);
        TreeNode right = helper(root.right, a ,b);

        if(left != null && right != null) {

            return root;

        } else if(root == q || root == p) {
            
            return root;

        } else if(left != null) { // right == null

            return left;

        } else if(right != null) { // left == null

            return right;

        } else {

            return null;

        }

    }
}
