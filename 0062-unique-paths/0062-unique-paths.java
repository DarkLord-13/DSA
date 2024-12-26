class Solution{
    int m, n; Integer[][] memo;
    public int uniquePaths(int mx, int nx){
        m = mx; n = nx;
        memo = new Integer[m][n];

        return f(0, 0);
    }
    int f(int i, int j){
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        if(memo[i][j]!=null) return memo[i][j];

        return memo[i][j] = f(i+1, j) + f(i, j+1);
    }
}