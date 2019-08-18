
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulateTree {
    public void connect(TreeLinkNode root) {
        TreeLinkNode ptr;
        TreeLinkNode head;

        head = root;
        ptr = head;
        while(head!=null && head.left!=null) {
        	ptr = head;
        	TreeLinkNode dummy = new TreeLinkNode(-1);
        	while(ptr!=null) {
        		dummy.next = ptr.left;
        		ptr.left.next=ptr.right;
        		dummy = ptr.right;
        		ptr = ptr.next;
        	}
        	head = head.left;
        }
    }

}