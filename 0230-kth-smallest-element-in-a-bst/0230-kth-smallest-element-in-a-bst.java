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
    int k, ret, step = 0;
    public int kthSmallest(TreeNode root, int kx){
        k = kx;
        ret = -1;

        f(root);

        return ret;
    }
    void f(TreeNode root){
        if(root == null || ret != -1){
            return;
        }
        if(step == k){
            ret = root.val;
        }
        
        f(root.left); 
        step += 1;
        if(step == k) ret = root.val;       
        // System.out.println(root.val + " " + step);
        f(root.right);
    }
}