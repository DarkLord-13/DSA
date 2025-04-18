class Solution{
    class Node{
        int min, max, sum;

        public Node(int min, int max, int sum){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    int maxSum = 0;
    public int maxSumBST(TreeNode root){
        Node node =  f(root);

        return maxSum;
    }
    Node f(TreeNode root){
        if(root==null){
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Node l = f(root.left);
        Node r = f(root.right);

        if(l.max < root.val && r.min > root.val){
            maxSum = Math.max(maxSum,root.val + l.sum + r.sum);

            return new Node(
                Math.min(l.min, root.val),
                Math.max(r.max, root.val),
                root.val + l.sum + r.sum
            );
        }        

        return new Node(
            Integer.MIN_VALUE, Integer.MAX_VALUE, 0
        );
    }
}