class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class CountCompleteTree {
	private int height = 0;
	private int count = 0;
	private int subtractor = 0;

	public int countNodes(TreeNode root) {
		if(root==null) return 0;
		height = getH(root);
		subtractor = (int)Math.pow(2,height-1);
		count=count+subtractor-1;

        binarySearch(root);

		return count;
	}

	public int getH(TreeNode root) {
		if(root==null) return 0;
		int h = 1;
		TreeNode ptr = root;
		while(ptr.left!=null) {
			h++;
			ptr = ptr.left;
		}
		return h;
	}

	public void binarySearch(TreeNode root) {
		if(height==1) {
			count++;
			return;
		}
		//System.out.println(height);
		height--;
		subtractor/=2;
		if(getH(root.right)==height) {
			count += subtractor;
			binarySearch(root.right);
		} else {
			binarySearch(root.left);
		}
	}
}