/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;

        for(int i = 1; i< m; i++) {
            pointer = pointer.next;
        }

        ListNode lastNodeBeforeReverse = pointer;
        ListNode prev = null;

        pointer = pointer.next;

        ListNode tailNodeOfReversedList = pointer;

        for(int i = m; i <= n; i++) {
            ListNode next = pointer.next;
            pointer.next = prev;
            prev = pointer;
            pointer = next;
        }

        tailNodeOfReversedList.next = pointer;
        lastNodeBeforeReverse.next = prev;

        return dummy.next;
    }
}
