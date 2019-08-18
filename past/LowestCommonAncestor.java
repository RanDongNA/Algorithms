public class LowestCommonAncestor {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		if((p.val<=root.val && root.val<=q.val) || (q.val<=root.val && root.val<=p.val)) {
			return root;
		} else if(p.val<root.val && q.val<root.val)
			return lowestCommonAncestor(root.left,p,q);
		else
			return lowestCommonAncestor(root.right.p.q);
	}
}


       _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5