class Solution{
    class Pair{
        TreeNode node;
        int i, j;

        public Pair(TreeNode node, int i, int j){
            this.node = node;
            this.i = i;
            this.j = j;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> ll = new LinkedList<>();
        if(root==null){
            return ll;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> {
            if(a.i==b.i && a.j==b.j){
                return a.node.val - b.node.val;
            }
            else if(a.i != b.i){
                return a.i - b.i;
            }
            else{
                return a.j - b.j;
            }            
        });
        q.add(new Pair(root, 0, 0));

        while(!q.isEmpty()){
            int s = q.size();

            for(int x=0; x<s; x++){
                Pair poll = q.poll();
                TreeNode node = poll.node;
                int i = poll.i;
                int j = poll.j;

                if(!map.containsKey(j)){
                    map.put(j, new ArrayList<>());
                }
                map.get(j).add(node.val);

                if(node.left!=null){
                    q.add(new Pair(node.left, i+1, j-1));
                }
                if(node.right!=null){
                    q.add(new Pair(node.right, i+1, j+1));
                }
            }
        } 

        int min = 99999;
        int max = -99999;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
            int key = entry.getKey();
            min = Math.min(min, key);
            max = Math.max(max, key);            
        }

        for(int i=min; i<=max; i++){
            ll.add(map.get(i));
        }

        return ll;
    }
}