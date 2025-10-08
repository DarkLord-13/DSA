/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution{

    private Map<Integer, List<TreeNode>> memo;

    public List<TreeNode> allPossibleFBT(int n){
        if(n % 2 == 0) return new ArrayList<>();

        this.memo = new HashMap<>();

        return f(n);
    }

    private List<TreeNode> f(int n){
        if(n == 1){
            List<TreeNode> l = new ArrayList<>();
            l.add(new TreeNode(0));
            memo.put(1, l);
            return l;
        }

        if(memo.containsKey(n)) return memo.get(n);

        List<TreeNode> res = new ArrayList<>();

        for(int L=1; L<=n-2; L+=2){
            int R = n - L - 1;
            
            List<TreeNode> left = f(L);
            List<TreeNode> right = f(R);                

            for(TreeNode l: left){                    
                for(TreeNode r: right){

                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }                
            
        }

        memo.put(n, res);
        return res;
    }
}