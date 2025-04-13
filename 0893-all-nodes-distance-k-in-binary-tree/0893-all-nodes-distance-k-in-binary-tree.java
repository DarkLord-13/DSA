class Solution{
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Set<TreeNode> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                TreeNode poll = q.poll();

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
        // for(Map.Entry<TreeNode, TreeNode> entry: map.entrySet()){
        //     System.out.println(entry.getKey().val + " " + entry.getValue().val);
        // }

        q.add(target);
        set.add(target);
        for(int i=0; i<=k; i++){
            int s = q.size();

            for(int j=0; j<s; j++){
                TreeNode poll = q.poll();                
                // System.out.print(poll.val + " ");

                if(poll.left!=null && !set.contains(poll.left)){
                    //System.out.print(poll.left.val + " ");
                    q.add(poll.left);
                    set.add(poll.left);
                }
                if(poll.right!=null && !set.contains(poll.right)){
                    //System.out.print(poll.right.val + " ");
                    q.add(poll.right);
                    set.add(poll.right);
                }
                if(map.containsKey(poll) && !set.contains(map.get(poll))){
                    //System.out.print(map.get(poll).val + " ");
                    q.add(map.get(poll));
                    set.add(map.get(poll));
                }

                if(i==k){
                    l.add(poll.val);
                }
            }
            //System.out.println();
        }

        return l;
    }
}