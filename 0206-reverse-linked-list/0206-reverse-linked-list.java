class Solution{
    public ListNode reverseList(ListNode h){
        ListNode p = null, n = null;

        while(h != null){
            n = h.next;
            h.next = p;
            p = h;
            h = n;
        }

        return p;
    }
}