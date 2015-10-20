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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) {
            return head;
        }
        
        // count;
        int count = 0;
        ListNode ptr = head;
        while(ptr != null) {
            count++;
            ptr = ptr.next;
        }
        
        if(n > count) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ptr = dummy;
        for(int i = 0; i < count - n; i++) {
            ptr = ptr.next;
        }
        
        ptr.next = ptr.next.next;
        
        return dummy.next;
    }
}

