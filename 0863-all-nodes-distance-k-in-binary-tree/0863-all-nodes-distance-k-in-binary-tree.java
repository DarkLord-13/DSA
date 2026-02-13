/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{

    private Map<TreeNode, TreeNode> parent;
    private int k;
    private List<Integer> ans;
    private Set<TreeNode> set;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        this.parent = new HashMap<>();  
        dfs(root, null);

        this.k = k;
        this.ans = new ArrayList<>();
        this.set = new HashSet<>();

        f(target, parent.get(target), 0);

        return ans;
    }

    private void f(TreeNode root, TreeNode p, int step){
        if(root == null || step > k || set.contains(root)) return;
        if(step == k) ans.add(root.val);

        set.add(root);
        f(root.left, root, step + 1);

        f(root.right, root, step + 1);

        // set.add(p);
        f(p, parent.get(p), step + 1);
    }

    private void dfs(TreeNode root, TreeNode p){
        if(root == null) return;

        parent.put(root, p);

        dfs(root.left, root);
        dfs(root.right, root);
    }
}