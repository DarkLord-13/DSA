class Solution{
    public List<Integer> eventualSafeNodes(int[][] graph){
        int n = graph.length;
        int[] v = new int[n];

        for(int i=0; i<n; i++){
            if(graph[i].length == 0){
                v[i] = 2;
            }
        }

        for(int i=0; i<n; i++){
            if(v[i] == 0){
                f(i, v, graph);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(v[i] == 2){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean f(int i, int[] v, int[][] g){
        if(v[i] != 0){
            if(v[i] == 1) return false;
            else return true;
        }

        v[i] = 1;

        for(int next: g[i]){
            if(!f(next, v, g)){
                v[next] = 1;
                return false;
            }
        }

        v[i] = 2;

        return true;
    }
}