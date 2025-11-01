class Solution{

    private int[][] g, v;
    private int n;
    private Integer[][][] memo;

    public int cherryPickup(int[][] g){
        this.g = g;
        this.n = g.length;
        this.v = new int[n][n];
        this.memo = new Integer[n][n][n];

        int ret = f(0, 0, 0); 

        return ret < 0 ? 0 : ret;   
    }

    private int f(int i, int j, int x){
        int y = i + j - x;

        if(i >= n || j >= n || x >= n || y >= n) return -99999;
        if(g[i][j] == -1 || g[x][y] == -1) return -99999;

        if(i == n - 1 && j == n - 1) return g[i][j];

        if(memo[i][j][x] != null) return memo[i][j][x];

        int curr = 0;
        if(i == x && j == y) curr = g[i][j];
        else curr = g[i][j] + g[x][y];

        int nextMax = Math.max(
            Math.max(f(i + 1, j, x), f(i + 1, j, x + 1)),
            Math.max(f(i, j + 1, x), f(i, j + 1, x + 1))
        );

        return memo[i][j][x] = curr + nextMax;
    }
}