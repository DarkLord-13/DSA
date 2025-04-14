class Solution{
    public int amountOfTime(TreeNode root, int start){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode target = new TreeNode();

        // making the <child, parent> map
        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                TreeNode poll = q.poll();
                if(poll.val==start){
                    target = poll;
                }

                if(poll.left!=null){
                    q.add(poll.left);
                    map.put(poll.left, poll);
                }
                if(poll.right!=null){
                    q.add(poll.right);
                    map.put(poll.right, poll);
                }
            }
        }

        q.add(target); 
        set.add(target);
        int minutes = 0;
        while(!q.isEmpty()){
            int s = q.size();            

            for(int i=0; i<s; i++){
                TreeNode poll = q.poll();

                if(poll.left!=null && !set.contains(poll.left)){
                    q.add(poll.left);
                    set.add(map.get(poll.left));
                }
                if(poll.right!=null && !set.contains(poll.right)){
                    q.add(poll.right);
                    set.add(map.get(poll.right));
                }
                if(poll!=root && !set.contains(map.get(poll))){
                    q.add(map.get(poll));
                    set.add(map.get(poll));
                }
            }
            minutes++;            
        } 

        return minutes-1;
    }
}