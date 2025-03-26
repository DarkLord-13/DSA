class Solution{
    // Set<Integer> terminal = new HashSet<>();
    int n;
    int[][] graph;
    int[] v;
    public List<Integer> eventualSafeNodes(int[][] gx){
        graph = gx;
        n = graph.length;
        v = new int[n];
        List<Integer> l = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(isSafe(i)){
                l.add(i);
            }
        }
       
        Collections.sort(l);
        return l;
    }
    boolean isSafe(int i){
        if(v[i]!=0){ // visited
            if(v[i]==2){ // safe
                return true;
            }
            else{ // unsafe
                return false;
            }
        }

        v[i] = 1;

        for(int next: graph[i]){
            if(!isSafe(next)){
                return false;
            }
        }

        v[i] = 2;

        return true;
    }
    void print(Boolean[] arr){
        for(Boolean i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}