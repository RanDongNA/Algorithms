public class Palin {
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
        ListNode p = head;
        List<Integer> temp= new ArrayList<Integer>();
        while(p!=null) {
            temp.add(p.val);
            p=p.next;
        }
        int size = temp.size();
        for(int i=0;i<size/2;i++) {
            if(temp.get(i)!=temp.get(size-1-i))
                return false;
        }
        return true;
        
        
    }
}