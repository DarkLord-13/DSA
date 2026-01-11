class Solution{
    public boolean flipEquiv(TreeNode root1, TreeNode root2){
        return f(root1, root2);
    }

    private boolean f(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        else if(a == null || b == null) return false;
        else if(a.val != b.val) return false;

        boolean t1 = false, t2 = false;

        if(
            (
                (
                    a.left != null && b.left != null && 
                    a.left.val == b.left.val
                ) || 
                (
                    a.left == null && b.left == null
                )
            ) && 
            (
                (
                    a.right != null && b.right != null && 
                    a.right.val == b.right.val
                ) ||
                (
                    a.right == null && b.right == null
                )
            )
        ){
            t1 = f(a.left, b.left) && f(a.right, b.right);
        }
        else if(
            (
                (
                    a.left != null && b.right != null &&
                    a.left.val == b.right.val
                ) ||
                (
                    a.left == null && b.right == null
                )
            ) &&
            (
                (
                    a.right != null && b.left != null &&
                    a.right.val == b.left.val
                ) ||
                (
                    a.right == null && b.left == null
                )
            )
        ){
            t2 = f(a.left, b.right) && f(a.right, b.left);
        }

        return t1 || t2;
    }
}