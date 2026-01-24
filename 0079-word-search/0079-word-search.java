class Solution{

    private int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};

    public boolean exist(char[][] g, String w){
        int m = g.length, n = g[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == w.charAt(0)){
                    if(f(i, j, 0, w, new int[g.length][g[0].length], g)) return true;
                }
            }
        }

        return false;
    }

    private boolean f(int i, int j, int pos, String w, int[][] v, char[][] g){
        if(pos == w.length() - 1) return true;

        v[i][j] = 1;
        
        for(int p=0; p<4; p++){
            int ni = i + x[p], nj = j + y[p];

            if(isSafe(ni, nj, pos, w, g, v)){
                if(f(ni, nj, pos + 1, w, v, g)){
                    return true;
                }
            }
        }

        v[i][j] = 0;
                    

        return false;
    }

    private boolean isSafe(int i, int j, int pos, String w, char[][] g, int[][] v){
        if(i < 0 || j < 0 || i >= g.length || j >= g[0].length || pos >= w.length()) return false;
        else if(g[i][j] != w.charAt(pos + 1) || v[i][j] == 1) return false;
        else return true;
    }
}