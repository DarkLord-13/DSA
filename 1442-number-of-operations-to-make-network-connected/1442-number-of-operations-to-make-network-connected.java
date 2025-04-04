class Solution{
    List<List<Integer>> adj = new ArrayList<>();
    int[] v;
    public int makeConnected(int n, int[][] connections){
        if(connections.length < n-1) return -1;
        
        v = new int[n];
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: connections){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int c = 0; // no. of distinct components in the graph
        for(int i=0; i<n; i++){
            if(v[i]==0){
                dfs(i);
                c++;
            }
        }

        return c-1;
    }
    void dfs(int i){        
        v[i] = 1;

        for(int next: adj.get(i)){
            if(v[next]==0) dfs(next);
        }
    }
}