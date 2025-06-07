class Solution{
    public TreeNode bstFromPreorder(int[] pre){
        return f(pre, 0, pre.length-1);
    }
    TreeNode f(int[] pre, int ps, int pe){
        if(ps > pe){
            return null;
        }

        TreeNode root = new TreeNode(pre[ps]);

        int i = 0;
        for(i=ps+1; i<=pe; i++){
            if(pre[i] >= pre[ps]) break;
        }

        root.left = f(pre, ps+1, i-1);
        root.right = f(pre, i, pe);

        return root;
    }
}