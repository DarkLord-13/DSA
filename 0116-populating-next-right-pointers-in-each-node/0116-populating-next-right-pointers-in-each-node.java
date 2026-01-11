class Solution{
    public Node connect(Node root){
        if(root == null) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                Node curr = q.poll();
                if(i < s - 1) curr.next = q.peek();

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }

        return root;
    }
}