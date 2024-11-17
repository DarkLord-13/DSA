class Solution{
    int[] c; int n, a, max = Integer.MAX_VALUE; int[][] memo;
    int mini = max;
    public int coinChange(int[] cx, int ax){
        c = cx; n = c.length; a = ax;
        if(a<=0) return 0;
        memo = new int[n][a+1];        
        for(int i=0; i<n; i++) Arrays.fill(memo[i], max);

        f(0, 0, 0);
        if(mini==max) return -1; 
        return mini;
    }
    void f(int i, int nc, int s){
        if(s==a){
            mini = Math.min(mini, nc);
            memo[i][s] = mini;
            return;
        }
        if(i>=n || s>a || nc>=mini) return;
        if(memo[i][s]<=nc) return;
        memo[i][s] = nc;

        f(i, nc+1, s+c[i]);
        f(i+1, nc, s); 
    }
}