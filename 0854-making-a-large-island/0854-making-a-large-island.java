class Solution{
    void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y){
            return;
        }        

        if(s[x] > s[y]){
            p[y] = x;
            s[x] += s[y];
        }
        else{
            p[x] = y;
            s[y] += s[x];
        }
    }
    int find(int x){
        if(p[x] != x){
            return p[x] = find(p[x]);
        }

        return p[x];
    }
    int[] p, s;
    int n;
    int[][] g, v;
    int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};
    public int largestIsland(int[][] g){
        this.g = g;
        n = g.length;
        v = new int[n][n];
        p = new int[n*n];
        s = new int[n*n];

        for(int i=0; i<n*n; i++){
            p[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 1){
                    s[j + n*i] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(v[i][j] == 0 && g[i][j] == 1){
                    dfs(i, j, i, j);
                }
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                if(g[i][j] == 0){
                    int c = 0;
                    Set<Integer> set = new HashSet<>();

                    for(int p=0; p<4; p++){
                        int ni = i + x[p], nj = j + y[p];

                        if(ni >= 0 && ni < n && nj >= 0 && nj < n && g[ni][nj] == 1){
                            int parentNode = find(nj + n * ni);

                            if(!set.contains(parentNode)){
                                set.add(parentNode);
                                c += s[parentNode];
                            }
                        }
                    }

                    max = Math.max(max, c + 1);
                }
            }
        }

        return max == 0 ? n*n : max;
    }
    void dfs(int i, int j, int pi, int pj){
        if(!isSafe(i, j)){
            return;
        }

        v[i][j] = 1;
        union(j + n*i, pj + n * pi);

        for(int p=0; p<4; p++){
            dfs(i+x[p], j+y[p], pi, pj);
        }
    }
    boolean isSafe(int i, int j){
        if(i < 0 || j < 0 || i >= n || j >= n || v[i][j] == 1 || g[i][j] == 0){
            return false;
        }

        return true;
    }
}