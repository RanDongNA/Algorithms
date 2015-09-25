public class LowestCommonAncestorM {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if(root==null) // reach the end
			return null;
		
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		
		if(left!=null && right!=null)
			return root;
		else if(root.val==p.val || root.val==q.val)
			return root;
		else if(left!=null)
			return left;
		else if(right!=null)
			return right;
		else
			return null;
	
	}
}



       _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5