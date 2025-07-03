public class Solution{
    public ListNode getIntersectionNode(ListNode a, ListNode b){
        int la = 0, lb = 0;
        ListNode t = a;

        while(t != null){
            t = t.next;
            la++;
        }

        t = b;

        while(t != null){
            t = t.next;
            lb++;
        }

        if(la > lb){
            for(int i=0; i<la-lb; i++){
                a = a.next;
            }
        }
        else if(lb > la){
            for(int i=0; i<lb-la; i++){
                b = b.next;
            }
        }

        while(a != b){
            a = a.next;
            b = b.next;
        }

        return a;
    }
}