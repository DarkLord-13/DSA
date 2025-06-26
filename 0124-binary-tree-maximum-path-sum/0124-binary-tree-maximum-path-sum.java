class Solution{
    int max;
    public int maxPathSum(TreeNode root){
        max = root.val;

        f(root);

        return max;
    }
    int f(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = f(root.left);
        int right = f(root.right);

        max = Math.max(max, root.val + left + right);

        return Math.max(0, Math.max(root.val + left, root.val + right));
    }
}