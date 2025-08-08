class Solution{
    public ListNode deleteDuplicates(ListNode h){
        ListNode dummy = new ListNode(-1);
        dummy.next = h;
        ListNode prev = dummy;

        while(h != null && h.next != null){
            if(h.val == h.next.val){
                int val = h.val;
                while(h != null && h.val == val){
                    h = h.next;
                }

                prev.next = h;
            }
            else{
                prev = h;
                h = h.next;
            }            
        }

        return dummy.next;
    }
}