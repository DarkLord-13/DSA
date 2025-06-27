class Solution{
    int[][] g;
    int m, n;
    int median(int[][] gx){
        g = gx;
        m = g.length; n = g[0].length;
        int l = g[0][0], h = g[m-1][n-1];
        
        for(int i=0; i<m; i++){
            l = Math.min(l, g[i][0]);
            h = Math.max(h, g[i][n-1]);
        }
        
        int left = (m * n) >> 1;
        
        while(l <= h){
            int mid = (l + h) >> 1;
            
            int lse = 0;
            for(int i=0; i<m; i++){
                lse += f(i, mid);
            }
            
            if(lse > left){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        
        return l;
    }
    int f(int row, int num){
        
        int c = 0;
        for(int j=0; j<n; j++){
            if(g[row][j] <= num){
                c++;
            }
        }
        
        return c;
    }
}