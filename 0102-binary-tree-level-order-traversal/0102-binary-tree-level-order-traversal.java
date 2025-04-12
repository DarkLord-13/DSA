class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ll = new ArrayList<>();
        if(root==null){
            return ll;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int s = q.size();
            for(int i=0; i<s; i++){
                TreeNode poll = q.poll();
                l.add(poll.val);

                if(poll.left!=null){
                    q.add(poll.left);
                }
                if(poll.right!=null){
                    q.add(poll.right);
                }
            }
            ll.add(l);
        }

        return ll;
    }
}