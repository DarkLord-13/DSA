class CBTInserter{
    
    private TreeNode root;
    private int total;

    public CBTInserter(TreeNode root){
        this.root = root;  
        this.total = getNodesCount(root);  
    }
    
    public int insert(int val){
        int n = total + 1;
        total++;

        TreeNode parent = findValidParent(this.root, 1, n, val);

        return parent.val;
    }
    
    public TreeNode get_root(){
        return this.root;
    }

    private TreeNode findValidParent(TreeNode parent, int rn, int n, int val){
        if(parent == null) return null;

        if(rn * 2 == n){
            parent.left = new TreeNode(val);
            return parent;
        }
        else if(rn * 2 + 1 == n){
            parent.right = new TreeNode(val);
            return parent;
        }

        TreeNode l = findValidParent(parent.left, rn * 2, n, val);
        TreeNode r = findValidParent(parent.right, rn * 2 + 1, n, val);

        if(l != null) return l;
        else if(r != null) return r;
        else return null;
    }

    private int getNodesCount(TreeNode root){
        if(root == null) return 0;

        return 1 + getNodesCount(root.left) + getNodesCount(root.right);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */