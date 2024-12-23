class Solution{
    public void rotate(int[][] g){
        int n=g.length;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int temp = g[i][j];
                g[i][j] = g[j][i];
                g[j][i] = temp;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int temp = g[i][j];
                g[i][j] = g[i][n-j-1];
                g[i][n-j-1] = temp;
            }
        }
    }
}