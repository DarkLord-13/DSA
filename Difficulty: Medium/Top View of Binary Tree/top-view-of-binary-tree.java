class Solution{
    class Pair{
        int i;
        Node root;
        
        public Pair(Node root, int i){
            this.root = root;
            this.i = i;
        }
    }
    ArrayList<Integer> topView(Node root){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty()){
            int s = q.size();
            
            for(int x=0; x<s; x++){
                Pair p = q.poll();
                Node node = p.root;
                int i = p.i;
                
                if(!map.containsKey(i)){
                    map.put(i, node.data);
                }
                
                if(node.left != null){
                    q.add(new Pair(node.left, i-1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, i+1));
                }
            }
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            l.add(entry.getValue());
        }
        return l;
    }
}