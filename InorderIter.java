 import java.util.*;	
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class InorderIter {
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	s = new Stack<TreeNode>();
	    	result = new ArrayList<Integer>();    

	    	examine(root);
	    	while(s.size()>0) {
	    		TreeNode temp = s.pop();
	    		result.add(temp.val);
	    		examine(temp.right);
	    	}

	    	return result;
	    }

	    private Stack<TreeNode> s;
	    private List<Integer> result;

	    public void examine(TreeNode root) {
	    	TreeNode ptr = root;
	    	while(ptr!=null) {
	    		s.push(ptr);
	    		ptr = ptr.left;
	    	}
	    }
}