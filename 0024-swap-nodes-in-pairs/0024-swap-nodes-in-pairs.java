class Solution{
    public ListNode swapPairs(ListNode h){
        if(h == null || h.next == null){
            return h;
        }       

        ListNode dummy = new ListNode(0);
        dummy.next = h.next;
        ListNode p = dummy;

        while(h != null && h.next != null){
            ListNode n = h.next;
            ListNode nn = n.next;

            p.next = n;
            n.next = h;
            h.next = nn;

            p = h;
            h = h.next;
        }
        
        return dummy.next;
    }
}