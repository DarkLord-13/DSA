class Solution{
    int[] parent;
    int[] s;
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return;
        }

        if(s[x]>s[y]){
            parent[y] = x;
            s[x] += s[y];
        }
        else{
            parent[x] = y;
            s[y] += s[x];
        }
    }

    int[][] v;
    int[][] g;
    int[] x = {-1, 0, +1, 0};
    int[] y = {0, +1, 0, -1};
    int n;
    public int largestIsland(int[][] gx){
        g = gx;
        n = g.length;
        parent = new int[n*n];
        s = new int[n*n];
        for(int i=0; i<n*n; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j]==1){
                    s[i*n + j] = 1;
                }
                else{
                    s[i*n + j] = 0;
                }
            }
        }
        v = new int[n][n];        

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(v[i][j]==0 && g[i][j]==1){
                    dfs(i, j);
                }
            }
        }

        for(int i=0; i<n*n; i++){
            parent[i] = find(parent[i]);
        } 
        // print(s);

        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                max = Math.max(max, s[i*n + j]);
                if(g[i][j]==0){
                    int sum = 0;
                    Set<Integer> set = new HashSet<>();

                    for(int p=0; p<4; p++){
                        int ni = i+x[p];
                        int nj = j+y[p];                        

                        if(isSafe(ni, nj)){
                            int up = parent[ni*n + nj];

                            if(!set.contains(up)){
                                sum += s[up];
                                set.add(up);
                            }                        
                        }
                    }

                    max = Math.max(max, sum+1);
                }
            }
        }

        return max;
    }
    void dfs(int i, int j){
        v[i][j] = 1;

        for(int p=0; p<4; p++){
            int ni = i + x[p];
            int nj = j + y[p];

            if(isSafe(ni, nj) && v[ni][nj]==0){
                union(i*n + j, ni*n + nj);
                dfs(ni, nj);
            }
        }
    }
    boolean isSafe(int i, int j){
        if(i<0 || j<0 || i>=n || j>=n || g[i][j]==0){
            return false;
        }
        else{
            return true;
        }
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

