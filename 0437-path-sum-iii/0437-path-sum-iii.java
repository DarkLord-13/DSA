class Solution{

    private int c, t;
    private Map<Long, Integer> map;

    public int pathSum(TreeNode root, int t){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            return root.val == t ? 1 : 0;        
        }

        this.c = 0;
        this.t = t;
        this.map = new HashMap<>();
        map.put(0L, 1);

        f(root, root.val);

        return c;
    }

    private void f(TreeNode root, long sum){
        if(root == null) return;
        if(map.containsKey(sum - t)){
            c += map.get(sum - t);
        }
        if(map.containsKey(sum)){
            map.put(sum, map.get(sum) + 1);
        }
        else{
            map.put(sum, 1);
        }

        if(root.left != null) f(root.left, sum + root.left.val);
        if(root.right != null) f(root.right, sum + root.right.val);

        map.put(sum, map.get(sum) - 1);
    }
}