class Solution{
    List<List<Integer>> adj = new ArrayList<>();
    List<Integer> l = new ArrayList<>();
    public int[] findOrder(int nc, int[][] pre){
        for(int i=0; i<nc; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a: pre){
            adj.get(a[1]).add(a[0]);
        } //System.out.println(adj);

        for(int i=0; i<nc; i++){
            if(cycle(i, new int[nc])){
                return new int[0];
            }
        }

        int[] v = new int[nc];
        for(int i=0; i<nc; i++){
            if(v[i] == 0){
                f(i, v);
            }
        }

        int[] ret = new int[nc];
        for(int i=0; i<nc; i++){
            ret[i] = l.get(nc-i-1);
        }

        return ret;
    }
    boolean cycle(int i, int[] v){
        if(v[i] == 1){
            return true;
        }
        v[i] = 1;

        for(int next: adj.get(i)){
            if(cycle(next, v)){
                return true;
            }
        }
        v[i] = 0;

        return false;
    }
    void f(int i, int[] v){
        if(v[i] == 1){
            return;
        }
        v[i] = 1;

        for(int next: adj.get(i)){
            f(next, v);
        }
        l.add(i);
    }
}