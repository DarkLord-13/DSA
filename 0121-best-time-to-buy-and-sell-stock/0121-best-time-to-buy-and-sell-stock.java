class Solution{
    int[] p; int n;
    int[][] memo;
    public int maxProfit(int[] px){
        p=px; n=p.length;
        memo = new int[n][3]; 
        for(int i=0; i<n; i++)
            Arrays.fill(memo[i], -1);

        return f(0, 0);     
    }
    int f(int i, int b){
        if(i>=n) return 0;
        if(memo[i][b]!=-1) 
            return memo[i][b];

        int x=0, y=0, z=0;
        if(b==0){
            x = -p[i] + f(i+1, 1);
        }
        else if(b==1){
            y = p[i] + f(i+1, 2);            
        }
        z = f(i+1, b);

        return memo[i][b] = Math.max(x, Math.max(y, Math.max(z, memo[i][b])));
    }
}