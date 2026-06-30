/*class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/

class Solution {
    
    private int ans;
    
    public int singlevalued(Node root) {
        this.ans = 0;
        
        f(root);
        
        return ans;
    }
    
    private int f(Node root) {
        if (root.left == null && root.right == null) {
            ans++;
            return root.data;
        }
        
        int left = root.data;
        if (root.left != null) {
            left = f(root.left);
        }
        
        int right = root.data;
        if (root.right != null) {
            right = f(root.right);
        }
        
        if (left == right && right == root.data && (left != -1 || right != -1)) {
            ans++;
            return root.data;
        }
        
        return -1;
    }
}