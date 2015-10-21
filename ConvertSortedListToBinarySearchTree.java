/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        if(head == null) {
            return null;
        }

        ListNode ptr = head;
        int count = 0;
        while(ptr != null) {
            ptr = ptr.next;
            count++;
        }

        return helper(head, count);
    }

    public TreeNode helper(ListNode head, int count) {
        if(count == 0 || head == null) {
            return null;
        }
        if(count == 1) {
            return new TreeNode(head.val);
        }

        ListNode ptr = head;
        int mid = (count - 1) / 2 + 1;
        
        for(int i = 1; i < mid; i++) {
            ptr = ptr.next;
        }
        TreeNode midNode = new TreeNode(ptr.val);

        midNode.right = helper(ptr.next, count - mid);
        ptr.next = null;
        midNode.left = helper(head, mid - 1);

        return midNode;
    }
}

