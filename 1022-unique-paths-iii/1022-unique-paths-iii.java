class Solution{
    private int[][] g, v;
    private int m, n, totalNonObstacles  = 0;
    private int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};

    public int uniquePathsIII(int[][] g){
        this.g = g;
        this.m = g.length;
        this.n = g[0].length;
        this.v = new int[m][n];

        int si = -1, sj = -1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 1){
                    si = i;
                    sj = j;
                }
                if(g[i][j] != -1){
                    totalNonObstacles ++;
                }
            }
        }
        // System.out.println(si + " " + sj);

        return f(si, sj, 1);
    }

    private int f(int i, int j, int steps){
        if(!isSafe(i, j)) return 0;
        if(g[i][j] == 2){
            if(steps == totalNonObstacles) return 1;
            else return 0;
        }
        v[i][j] = 1;

        // System.out.println(i + " " + j);

        int valid = 0;
        for(int p=0; p<4; p++){
            int ni = i + x[p], nj = j + y[p];

            valid += f(ni, nj, steps + 1);
        }

        v[i][j] = 0;

        return valid;
    }

    private boolean isSafe(int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || v[i][j] == 1 || g[i][j] == -1) return false;
        else return true;
    }
}