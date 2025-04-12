class Solution{
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root){
        int x = f(root);

        return d;
    }
    int f(TreeNode root){
        if(root==null){
            return 0;
        }

        int l = f(root.left);
        int r = f(root.right);

        d = Math.max(d, l+r);

        return 1 + Math.max(l, r);
    }
}