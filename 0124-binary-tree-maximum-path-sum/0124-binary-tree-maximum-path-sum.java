class Solution{
    int max;
    public int maxPathSum(TreeNode root){
        max = root.val;

        int x = f(root);

        return max;
    }
    int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = Math.max(f(root.left), 0);
        int r = Math.max(f(root.right), 0);

        max = Math.max(max, l + r + root.val);

        return root.val + Math.max(l, r);
    }
}