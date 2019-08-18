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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // try with O(n) space
        if(head == null) {
            return null;
        }

        HashSet<ListNode> hs = new HashSet<ListNode>();

        while(head != null) {
            if(hs.contains(head)) {
                return head;
            } else {
                hs.add(head);
            }
        }

        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        // try with O(1) space
        if(head == null || head.next == null) {
            return null;
        }

        ListNode slowPtr = head;
        ListNode fastPtr = head.next;
        while(fastPtr != slowPtr) {            
            if(fast == null || fast.next == null) {
                return null;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }

        return head;

    }
}

