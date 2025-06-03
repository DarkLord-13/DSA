class Solution{
    List<List<Integer>> ll = new ArrayList<>();
    int n;
    int[][] g;
    public List<List<Integer>> allPathsSourceTarget(int[][] gx){
        g = gx;
        n = g.length;

        f(0, new int[n], new ArrayList<>());

        return ll;
    }
    void f(int i, int[] v, List<Integer> l){
        if(v[i] == 1){
            return;
        }
        v[i] = 1;
        l.add(i);

        if(i == n-1){
            ll.add(new ArrayList<>(l));
            // return;
        }        

        for(int next: g[i]){
            f(next, v, l);
        }
        l.remove(l.size()-1);
        v[i] = 0;
    }
}