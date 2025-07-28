class Solution{
    int[] stones;
    int n, rs;
    int[][] memo;
    public int lastStoneWeightII(int[] stones){
        this.stones = stones;
        this.n = stones.length;
        this.memo = new int[n][3001];

        for(int i=0; i<n; i++) Arrays.fill(memo[i], -1);

        int ts = 0;
        for(int w: stones) ts += w;

        this.rs = ts/2;

        int min = f(0, 0, 0);

        return min;
    }
    int f(int i, int a, int b){
        if(i >= n){
            return Math.abs(a - b);
        }
        if(memo[i][a] != -1){
            return memo[i][a];
        }

        int x = f(i+1, a + stones[i], b);
        int y = f(i+1, a, b + stones[i]);

        return memo[i][a] = Math.min(x, y);
    }
}