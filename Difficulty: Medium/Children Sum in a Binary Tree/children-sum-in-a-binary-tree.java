
class Solution{
    public static int isSumProperty(Node root){
        boolean x = f(root);
        if(x) return 1;
        return 0;
    }
    static boolean f(Node root){
        if(root == null || (root.left==null && root.right==null)){
            return true;
        }
        
        int sum = 0;
        if(root.left != null) sum += root.left.data;
        if(root.right != null) sum += root.right.data;
        
        if(sum != root.data){
            return false;
        }
        else{
            return f(root.left) && f(root.right);
        }
    }
}