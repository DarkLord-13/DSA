class Solution{
    char[][] g;
    int m, n;
    boolean flag = false;
    int[] x = {-1, 0, +1, 0};
    int[] y = {0, +1, 0, -1};
    Boolean[][] memo;
    public boolean containsCycle(char[][] gx){
        g = gx;
        m = g.length;
        n = g[0].length;
        memo = new Boolean[m][n];

        int[][] v = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(v[i][j] == 0){
                    boolean x = f(i, j, -1, -1, g[i][j], v);
                }
            }
        }

        return flag;
    }
    boolean f(int i, int j, int pi, int pj, char c, int[][] v){
        if(!safe(i, j) || g[i][j] != c){
            return false;
        }       
        if(v[i][j] == 1){
            flag = true;
            return true;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        v[i][j] = 1;
        boolean ret = false;
        for(int p=0; p<4; p++){
            int ni = i+x[p];
            int nj = j+y[p];

            if(ni==pi && nj==pj){
                continue;
            }

            ret |= f(ni, nj, i, j, c, v);          
        }
        v[i][j] = 0;

        return memo[i][j] = ret;
    }
    boolean safe(int i, int j){
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }

        return true;
    }
}