class Solution{
    private static int m, n;
    private int[][] v;
    private static final int[] x = {-1, 0, +1, 0};
    private static final int[] y = {0, +1, 0, -1};
    private char[][] g;

    public void solve(char[][] g){
        this.g = g;
        this.m = g.length;
        this.n = g[0].length;
        this.v = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isBoundaryCell(i, j) && g[i][j] == 'O' && v[i][j] == 0){
                    dfs(i, j);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 'Y'){
                    g[i][j] = 'O';
                }
                else if(g[i][j] == 'O'){
                    g[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j){
        if(!isSafe(i, j)){
            return;
        }

        v[i][j] = 1;
        g[i][j] = 'Y';

        for(int p=0; p<4; p++){
            int ni = i+x[p], nj = j+y[p];

            dfs(ni, nj);
        }
    }

    boolean isSafe(int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n || g[i][j] == 'X' || v[i][j] == 1){
            return false;
        }
        else{
            return true;
        }
    }

    boolean isBoundaryCell(int i, int j){
        if((i == 0 || i == m-1 || j == 0 || j == n-1)){
            return true;
        }
        else{
            return false;
        }
    }
}