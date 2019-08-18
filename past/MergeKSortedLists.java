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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size() == 0) {
            return null;
        }
        
        if(lists.size() == 1) {
            return lists.get(0);
        }
        
        List<ListNode> list = new ArrayList<ListNode>();
        
        for(int i = 0; i < lists.size(); i+= 2) {
            if(i + 1 >= lists.size()) {
                list.add(lists.get(i));
            } else {
                ListNode partialResult = merge(lists.get(i), lists.get(i + 1));
                list.add(partialResult);
            }
        }

        return mergeKLists(list);

    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(0);
        ListNode ptr;
        ptr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                ptr.next = list1;
                ptr = ptr.next;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                ptr = ptr.next;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            ptr.next = list1;
        }
        if(list2 != null) {
            ptr.next = list2;
        }

        return dummy.next;
    }
}
