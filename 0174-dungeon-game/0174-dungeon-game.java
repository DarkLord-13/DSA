class Solution{

    private int[][] g;
    private int m, n;
    private Integer[][] memo;

    public int calculateMinimumHP(int[][] g){
        this.g = g;
        this.m = g.length;
        this.n = g[0].length;
        this.memo = new Integer[m][n];

        int ret = f(0, 0);    

        if(ret <= 0) return Math.abs(ret) + 1;
        else return 1;
    }

    private int f(int i, int j){
        if(i >= m || j >= n) return -999999;
        if(i == m - 1 && j == n - 1) return g[i][j];
        if(memo[i][j] != null) return memo[i][j];

        int down = Math.min(g[i][j], g[i][j] + f(i + 1, j));
        int right = Math.min(g[i][j], g[i][j] + f(i, j + 1));

        return memo[i][j] = Math.max(down, right);
    }
}