class Solution{
    int[] p;
    int n;
    Integer[][] memo;
    public int maxProfit(int[] p){
        this.p = p;
        this.n = p.length;
        this.memo = new Integer[n][2];

        return f(0, 0);
    }
    int f(int i, int b){
        if(i >= n){
            return 0;
        }
        if(memo[i][b] != null){
            return memo[i][b];
        }
        
        int buy = 0, sell = 0, skip = 0;

        if(b == 0){ // not bought
            buy = -p[i] + f(i+1, 1);
        }
        else if(b == 1){
            sell = p[i] + f(i+1, 0);
        }

        skip = f(i+1, b);

        return memo[i][b] = Math.max(buy, Math.max(sell, skip));
    }
}