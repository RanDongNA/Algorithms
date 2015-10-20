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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }
        
        ListNode dummyLess = new ListNode(0);
        ListNode dummyGreater = new ListNode(0);
        
        ListNode ptrLess = dummyLess;
        ListNode ptrGreater = dummyGreater;
        
        
        while(head != null) {
            if(head.val >= x){
                ptrGreater.next = head;
                ptrGreater = ptrGreater.next;
            } else {
                ptrLess.next = head;
                ptrLess = ptrLess.next;
            }
            head = head.next;
        }
        
        ptrGreater.next = null;
        ptrLess.next = null;
        
        head = dummyLess;
        while(head.next != null) {
            head = head.next;
        }
        head.next = dummyGreater.next;
        
        return dummyLess.next;
    }
}

