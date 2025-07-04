class Solution{
    public ListNode mergeKLists(ListNode[] l){
        PriorityQueue<ListNode> q = new PriorityQueue<>((a, b)-> a.val - b.val);
        int n = l.length;
        for(int i=0; i<n; i++){
            if(l[i] != null){
                q.add(l[i]);
            }
        }

        ListNode t = new ListNode(-1);
        ListNode h = t;

        while(!q.isEmpty()){
            ListNode poll = q.poll();

            h.next = new ListNode(poll.val);
            h = h.next;    

            poll = poll.next;        

            if(poll != null){
                q.add(poll);
            }
        }

        return t.next;
    }
}