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

    private int sum;

    public int sumNumbers(TreeNode root){
        this.sum = 0;

        f(root, new StringBuilder());

        return sum;
    }

    private void f(TreeNode root, StringBuilder sb){
        if(root == null){
            return;
        }

        if(isLeaf(root)){
            sb.append(root.val);
            sum += Integer.valueOf(sb.toString());
            sb.delete(sb.length() - 1, sb.length());
            return;
        }

        sb.append(root.val);
        f(root.left, sb);
        f(root.right, sb);
        sb.delete(sb.length() - 1, sb.length());
    }

    private boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null){
            return true;
        }
        else{
            return false;
        }
    }
}