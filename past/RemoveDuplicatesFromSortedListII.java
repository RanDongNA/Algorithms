public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevNode = dummy;
        
        while(head != null) {
            int thisNumber = head.val;
            
            if(head.next != null && head.next.val != thisNumber) {
                prevNode = head;
            } else if(head.next != null) {

                while(head.next != null 
                    && head.next.val == thisNumber) {
                    
                    head = head.next;
                }

                prevNode.next = head.next;
            } // end if

            head = head.next;
        } // end outer while

        return dummy.next;
    }
}