class Solution{
    int[] coins;
    int amount;
    int[][] memo;
    public int coinChange(int[] coins, int amount){
        this.coins = coins;
        this.amount = amount;
        this.memo = new int[coins.length][amount + 1];

        for(int i=0; i<coins.length; i++){
            Arrays.fill(this.memo[i], -1);
        }
        Arrays.sort(coins);

        int min = f(coins.length - 1, 0);

        return min == 999999 ? -1 : min;
    }
    int f(int i, int sum){
        if(sum == amount){
            return 0;
        }
        if(i < 0 || sum > amount){
            return 999999;
        }
        if(memo[i][sum] != -1){
            return memo[i][sum];
        }

        int p = 1 + f(i, sum + coins[i]);
        int np = f(i-1, sum);

        return memo[i][sum] = Math.min(p, np);
    }
}