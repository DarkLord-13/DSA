class Solution{
    int[] cost;
    int n;
    Integer[] memo;
    public int minCostClimbingStairs(int[] cost){
        this.cost = cost;
        this.n = cost.length;
        this.memo = new Integer[n];

        return Math.min(f(0), f(1));
    }
    int f(int i){
        if(i >= n){
            return 0;
        }
        if(memo[i] != null){
            return memo[i];
        }

        int a = cost[i] + f(i + 1);
        int b = cost[i] + f(i + 2);

        return memo[i] = Math.min(a, b);
    }
}