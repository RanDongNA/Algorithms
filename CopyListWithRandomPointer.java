/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map
            = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode ptr = head;       

        while(ptr != null) {
            RandomListNode copyNode = new RandomListNode(ptr.val);
            map.put(ptr, copyNode);
            ptr = ptr.next;
        }

        ptr = head;

        while(ptr != null) {
            RandomListNode deepCopyNode = map.get(ptr);
            deepCopyNode.next = map.get(ptr.next);
            deepCopyNode.random = map.get(ptr.random);
            ptr = ptr.next;
        }

        RandomListNode copyHead = map.get(head);
        return copyHeadl
    }


    // Now let's try O(1) space
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode ptr = head;

        while(ptr != null) {
            RandomListNode next = ptr.next;
            ptr.next = new RandomListNode(ptr.label);
            ptr = ptr.next;
            ptr.next = next;
            ptr = ptr.next;
        }

        ptr = head;

        while(ptr != null) {
            if(ptr.random != null) {
                ptr.next.random = ptr.random.next;
            } else {
                ptr.next.random = null;
            }
            ptr = ptr.next;
            ptr = ptr.next;
        }
                
        ptr = head;
        RandomListNode copyHead = ptr.next;
        RandomListNode copyPtr; 
        while(ptr != null) {
            copyPtr = ptr.next;

            RandomListNode next = copyPtr.next;
            if(next != null) {
                copyPtr.next = copyPtr.next.next;
            }
            ptr.next = next;
            ptr = next;
        }

        return copyHead;
    }
}