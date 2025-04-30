//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList<Integer> res = T.boundaryTraversal(root);
            for (Integer num : res) System.out.print(num + " ");
            System.out.println();
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{ // 1 2 3 4 5 6 7 N N 8 9 N N N N
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    ArrayList<Integer> leaf = new ArrayList<>();
    ArrayList<Integer> boundaryTraversal(Node root){
        if(root == null){
            return left;
        }
        if(root.left == null && root.right == null){
            left.add(root.data);
            return left;
        }
        
        left.add(root.data);
        tl(root.left); //System.out.println(left);
        td(root); //System.out.println(leaf);
        tr(root.right); 
        Collections.reverse(right);
        // right.remove(right.size() - 1); //System.out.println(right);
        
        left.addAll(leaf);
        left.addAll(right);
        
        return left;
    }
    void tl(Node root){
        if(root == null || isLeaf(root)){
            return;
        }
        
        left.add(root.data);
        
        if(root.left == null){
            tl(root.right);
        }
        else{
            tl(root.left);
        }
    }
    void tr(Node root){
        if(root == null || isLeaf(root)){
            return;
        }
        
        right.add(root.data);
        
        if(root.right == null){
            tr(root.left);
        }
        else{
            tr(root.right);
        }
    }
    void td(Node root){
        if(root == null){
            return;
        }
        
        if(isLeaf(root)){
            leaf.add(root.data);
        }
        td(root.left);
        td(root.right);
    }
    boolean isLeaf(Node root){
        if(root == null){
            return false;
        }
        else if(root.left == null && root.right == null){
            return true;
        }
        else{
            return false;
        }
    }
}
