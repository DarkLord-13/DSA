//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends



class Solution{
    public Node addOne(Node head){

        Node copy = listCopy(head);
        //print(copy);
        Node rev = reverseList(copy);
        //print(rev);
        Node dummy = rev;
        
        int c = 1;
        Node slow = null;
        boolean flag = false;
        while(rev!=null){
            slow = rev;
            int d = rev.data;
            if(d<9){
                d+=c;
                c=0;
                rev.data = d;
                flag=true;
                break;
            }
            else{
                rev.data=0;
            }
            rev = rev.next;
        }
        if(!flag){
            slow.next = new Node(1);
        }
        
        rev = reverseList(dummy);
        
        return rev;
    }
    Node listCopy(Node head){
        Node dummy = new Node(0);
        Node res = dummy;
        
        while(head!=null){
            res.next = new Node(head.data);
            res = res.next;
            head = head.next;
        }
        
        return dummy.next;
    }
    Node reverseList(Node head){
        Node curr = head;
        Node next = null;
        Node prev = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    void print(Node head){
        Node h = head;
        while(h!=null){
            System.out.print(h.data + " ");
            h = h.next;
        }
        
        System.out.println();
    }
}













