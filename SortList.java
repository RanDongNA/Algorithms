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
     * @return: You should return the head of the sorted linked list,
     *               using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        ListNode ptr = head;
        int count = 0;
        while(ptr != null) {
            count++;
            ptr = ptr.next;
        }
        return mergeHelper(head, count);
    }

    public ListNode mergeHelper(ListNode head, int count) {
        if(count == 0) {
            return null;
        }

        if(count == 1) {
            return head;
        }

        int stepsToMid = (count - 1) / 2;
        
        ListNode midNode = head;
        for(int i = 1; i <= stepsToMid; i++) {
            midNode = midNode.next;
        }
        
        ListNode l2 = mergeHelper(midNode.next, count - 1 - stepsToMid);
        midNode.next = null;
        ListNode l1 = mergeHelper(head, stepsToMid + 1);
       
        return merge(l1, l2);

    }

    public ListNode merge(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ptr.next = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                list2 = list2.next;
            }

            ptr = ptr.next;
        }

        if(list1 != null) {
            ptr.next = list1;
        } else if(list2 != null) {
            ptr.next = list2;
        }

        return dummy.next;
    }
}

