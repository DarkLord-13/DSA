class Solution{
    private int[] prices;
    private int n;
    private Integer[][] memo;
    public int maxProfit(int[] prices){
        this.prices = prices;
        this.n = prices.length;
        this.memo = new Integer[n][3];

        return f(0, 0);
    }
    int f(int i, int b){
        if(i >= n){
            return 0;
        }
        if(memo[i][b] != null){
            return memo[i][b];
        }

        int x = 0;
        if(b == 0){
            x = -prices[i] + f(i+1, 1);
        }

        int z = f(i+1, b);

        int y = 0;
        if(b == 1){
            y = prices[i] + f(i+1, 2);
        }

        return memo[i][b] = Math.max(x, Math.max(y, z));
    }
}