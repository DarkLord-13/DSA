class Solution{
    public int uniquePaths(int m, int n){
        if(m==1&&n==1) return n;
        int[][] memo = new int[m][n];
        
        memo[0][0] = 1;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(i==0 || j==0) memo[i][j] = 1;
                else{
                    memo[i][j] += (memo[i-1][j] + memo[i][j-1] + 1);
                }
            }
        }

        return memo[m-1][n-1]+1;
    }
}