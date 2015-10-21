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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if(head == null || head.next == null) {
            return;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        ListNode list1 = head;
        reverse(slowPtr);
        ListNode list2 = slowPtr.next;
        slowPtr.next = null;
        merge(list1, list2);
    }

    public void reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode ptr = head.next;
        ListNode next;

        while(ptr != null) {
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        head.next = prev;
    }

    public void merge(ListNode list1, ListNode list2) {
        while(list2 != null) {
            ListNode next = list2.next;
            list2.next = list1.next;
            list1.next = list2;
            list1 = list2.next;
            list2 = next;
        }
    }
}