class Solution{
    public ListNode partition(ListNode h, int x){
        ListNode dummy1 = new ListNode();
        ListNode less = dummy1;

        ListNode dummy2 = new ListNode();
        ListNode more = dummy2;

        while(h != null){
            if(h.val < x){
                less.next = h;
                less = less.next;
            }
            else{
                more.next = h;
                more = more.next;
            }

            h = h.next;
        }
        more.next = null;
        // print(less);
        // print(more);

        less.next = dummy2.next;
        return dummy1.next;
    }
    void print(ListNode h){
        ListNode t = new ListNode();
        t.next = h;
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        }

        System.out.println();
    }
}