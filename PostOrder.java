import java.util.*;
public class PostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> candidates = new Stack<TreeNode>();
        Stack<Integer> result = new Stack<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();

        if(root==null) return resultList;
        
        candidates.push(root);
        while(candidates.size()>0) {
        	TreeNode nextCandidate = candidates.pop();
        	result.push(nextCandidate.val);
        	if(nextCandidate.left!=null)
        		candidates.push(nextCandidate.left);
        	if(nextCandidate.right!=null)
        		candidates.push(nextCandidate.right);
        }
        while(result.size()>0) {
        	resultList.add(result.pop());
        }
        return resultList;
    }

    public static void main(String[] args) {
    	Stack<Integer> result = new Stack<Integer>();
    	result.push(1);
    	result.push(2);
    	result.push(3);
    	List<Integer> list= result;
    	System.out.println(list);
    	System.out.println(result);

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}