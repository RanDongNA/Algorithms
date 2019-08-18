public class TreePath {
    Stack<Integer> item;
    List<String> result;

    public void recur(TreeNode root) {
    	if(root==null) return;
    	
    	item.push(root.val);

    	if(root.right==null && root.left==null) {
    		
    		String[] all = item.toArray();
    		String partresult = all[0];

    		for(int i=1;i<all.length;i++) {
    			partresult = partresult+"->"+all[i];
    		}
    		result.add(partresult);
    		
    	} else {
    		recur(root.left);
    		recur(root.right);
    	}
    	item.pop();
    	
    	
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null) return null;

        item = new Stack<String>();
        result = new LinkedList<String>();

        recur(root);
        return result;
    }
}





Given a binary tree, return all root-to-leaf paths. 

For example, given the following binary tree: 


   1
 /   \
2     3
 \
  5



All root-to-leaf paths are: 
["1->2->5", "1->3"]
