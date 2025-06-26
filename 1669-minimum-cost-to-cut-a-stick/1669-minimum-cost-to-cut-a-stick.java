class Solution{
    int[] augCuts;
    int[][] memo;
    public int minCost(int n, int[] cuts){
        augCuts = new int[cuts.length + 2];
        for(int i=0; i<cuts.length; i++){
            augCuts[i] = cuts[i];
        }
        augCuts[cuts.length] = n;
        Arrays.sort(augCuts);

        memo = new int[augCuts.length][augCuts.length];
        for(int i=0; i<augCuts.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return f(0, augCuts.length-1);
    }
    int f(int i, int j){
        if(i+1 == j){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int best = Integer.MAX_VALUE;
        for(int k=i+1; k<j; k++){
            int cutCost = augCuts[j] - augCuts[i];
            int leftCost = f(i, k);
            int rightCost = f(k, j);

            best = Math.min(best, cutCost + leftCost + rightCost);
        }

        return memo[i][j] = best;
    }
}