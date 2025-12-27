class Solution{

    private int t;
    private List<List<Integer>> adj;

    public List<List<Integer>> pathSum(TreeNode root, int t){
        this.t = t;
        this.adj = new ArrayList<>();

        f(root, 0, new ArrayList<>());

        return adj;    
    }

    private void f(TreeNode root, int sum, List<Integer> l){
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            if(sum + root.val == t){
                l.add(root.val);
                adj.add(new ArrayList<>(l));
                l.remove(l.size() - 1);
            }

            return;
        }

        l.add(root.val);

        f(root.left, sum + root.val, l);
        f(root.right, sum + root.val, l);

        l.remove(l.size() - 1);
    }
}