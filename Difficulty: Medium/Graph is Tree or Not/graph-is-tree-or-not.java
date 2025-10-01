class Solution{
    
    private class DSU{
        
        private int[] p, r;
        
        public DSU(int n){
            this.p = new int[n];
            for(int i=0; i<n; i++) p[i] = i;
            
            this.r = new int[n];
        }
        
        private int find(int x){
            if(p[x] != x){
                return p[x] = find(p[x]);
            }
            
            return p[x];
        }
        
        private boolean union(int x, int y){
            x = find(x); 
            y = find(y);
            
            if(x == y) return false;
            
            if(r[x] > r[y]) p[y] = x;
            else if(r[x] < r[y]) p[x] = y;
            else{
                p[y] = x;
                r[x]++;
            }
            
            return true;
        }
        
    }
    
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges){
        DSU dsu = new DSU(n);
        
        for(ArrayList<Integer> edge: edges){
            int x = edge.get(0), y = edge.get(1);
            boolean goodUnion = dsu.union(x, y);
            
            if(!goodUnion){
                return false;
            }
        }
        
        for(int i=0; i<n; i++){
            dsu.p[i] = dsu.find(dsu.p[i]);
        }
        
        Set<Integer> uniqueParents = new HashSet<>();
        for(int parent: dsu.p){
            uniqueParents.add(parent);
        }
        // System.out.println(uniqueParents);
        // System.out.println(Arrays.toString(dsu.p));
        
        if(uniqueParents.size() > 1) return false;
        else return true;
    }
}









