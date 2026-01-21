class Solution{
    
    private class DSU{
        
        int[] p, r;
        
        public DSU(int n){
            this.p = new int[n];
            for(int i=0; i<n; i++){
                p[i] = i;
            }
            
            this.r = new int[n];
            Arrays.fill(r, 1);
        }
        
        int find(int x){
            if(p[x] != x){
                return p[x] = find(p[x]);
            }
            
            return p[x];
        }    
        
        void union(int x, int y){
            x = find(x); y = find(y);
            
            if(r[x] > r[y]){
                p[y] = p[x];
            }
            else if(r[x] < r[y]){
                p[x] = p[y];
            }
            else{
                r[x]++;
                p[y] = p[x];
            }
        }
    }
    
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges){
        DSU dsu = new DSU(n);
        
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<n; i++) ll.add(new ArrayList<>());
        
        for(ArrayList<Integer> e: edges){
            int from = e.get(0), to = e.get(1);
            
            ll.get(from).add(to);
            // ll.get(to).add(from);
            
            dsu.union(from, to);
        }
        
        for(int i=0; i<n; i++) dsu.p[i] = dsu.find(i);
        
        // System.out.println(Arrays.toString(dsu.p));
        
        for(int i=0; i<n-1; i++){
            if(dsu.p[i] != dsu.p[i + 1]) return false;
        }
        
        int[] v = new int[n];
        for(int i=0; i<n; i++){
            if(hasCycle(i, ll, v)){
                // System.out.println(Arrays.toString(v) + "---" + i);
                return false;
            }
        }
        
        return true;
    }
    
    private boolean hasCycle(int i, List<List<Integer>> ll, int[] v){
        if(v[i] == 1) return true;
        
        v[i] = 1;
        
        for(int next: ll.get(i)){
            if(hasCycle(next, ll, v)) return true;
        }
        
        v[i] = 0;
        
        return false;
    }
}









