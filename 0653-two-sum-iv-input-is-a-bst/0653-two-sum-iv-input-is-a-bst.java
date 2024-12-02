class Solution{
    boolean flag = false; int k; HashSet<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int kx){
        k = kx;
        f(root);
        return flag;
    }
    void f(TreeNode root){
        if(root==null) return;

        if(set.contains(root.val)) flag=true;
        set.add(k-root.val);

        f(root.left);
        f(root.right);
    }
}