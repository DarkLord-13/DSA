class Solution{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int c = 0;
        ListNode head = new ListNode(-1);
        ListNode ret = new ListNode(-1);
        ret.next = head;
        while(l1 != null && l2 != null){
            int a = l1.val;
            int b = l2.val;

            int sum = a+b+c;
            int d = sum;
            if(sum > 9){
                d = d%10;
            }
            c = sum/10;

            head.next = new ListNode();
            head = head.next;
            head.val = d;

            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int a = l1.val;
            int b = 0;
            int sum = a+b+c;
            int d = sum;
            if(sum > 9){
                d = d%10;
            }
            c = sum/10;

            head.next = new ListNode();
            head = head.next;
            head.val = d;

            l1 = l1.next;
        }

        while(l2 != null){
            int a = 0;
            int b = l2.val;
            int sum = a+b+c;
            int d = sum;
            if(sum > 9){
                d = d%10;
            }
            c = sum/10;

            head.next = new ListNode();
            head = head.next;
            head.val = d;

            l2 = l2.next;
        }
        
        if(c > 0){
            head.next = new ListNode();
            head = head.next;
            head.val = c;
        }

        return ret.next.next;
    }
}