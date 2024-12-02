class Solution{
    int s = 0;
    public boolean isPalindrome(ListNode h){
        ListNode dummy = new ListNode(); dummy.next = h;
        while(dummy.next!=null){
            dummy.next = dummy.next.next;
            s++;
        }

        dummy = h;
        for(int i=0; i<s/2; i++) dummy = dummy.next; 
        if(s%2!=0) dummy = dummy.next; 
        ListNode rev = reverse(dummy);
        
        for(int i=0; i<s/2; i++){
            if(h.val!=rev.val) return false;
            h = h.next; rev = rev.next;
        }

        return true;
    }
    ListNode reverse(ListNode h){
        ListNode c = h, p = null, n = null;
        while(c!=null){
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }

        return p;
    }
}