/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution{
    public Node copyRandomList(Node head){
        if(head == null){
            return head;
        }
        Node th = new Node(0);
        th.next = head;
        Node nh = new Node(0);
        Node t = new Node(0);
        nh.next = t;
        Map<Node, Node> map = new HashMap<>();

        int index = 0;
        while(head != null){         
            t.val = head.val;
            map.put(head, t);
            index++;

            if(head.next != null){
                t.next = new Node(0);
            }
            t = t.next;
            head = head.next;
        } 
        //print(nh.next);

        t = nh.next;
        head = th.next;
        index = 0;

        while(t != null){
            t.random = map.get(head.random);
            index++;

            head = head.next;
            t = t.next;
        }

        return nh.next;
    }
    void print(Node h){
        Node t = h;
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }
}