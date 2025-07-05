class Solution{
    int[] p, r;
    void union(int x, int y){
        x = find(x);
        y = find(y);

        if(r[x] > r[y]){
            p[y] = x;
        }
        else if(r[x] < r[y]){
            p[x] = y;
        }
        else{
            r[x]++;
            p[y] = x;
        }
    }
    int find(int x){
        if(p[x] != x){
            return p[x] = find(p[x]);
        }

        return p[x];
    }
    public int countComponents(int n, int[][] edges){
        this.p = new int[n];
        this.r = new int[n];

        for(int i=0; i<n; i++){
            p[i] = i;
        }

        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];

            union(x, y);
        }

        for(int i=0; i<n; i++){
            p[i] = find(p[i]);
        }

        Set<Integer> set = new HashSet<>();
        for(int i: p){
            set.add(i);
        }

        return set.size();
    }
}