class Solution{
    int[] augCuts;
    int[][] memo;
    public int minCost(int n, int[] cuts){
        augCuts = new int[cuts.length+2];
        for(int i=0; i<cuts.length; i++){
            augCuts[i+1] = cuts[i];
        }
        augCuts[augCuts.length-1] = n;
        Arrays.sort(augCuts);

        memo = new int[augCuts.length][augCuts.length];
        for(int i=0; i<augCuts.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return f(0, augCuts.length-1);
    }
    int f(int s, int e){
        if(s+1 == e){ // can't be cut further
            return 0;
        }
        if(memo[s][e]!=-1){
            return memo[s][e];
        }

        int best = Integer.MAX_VALUE;
        for(int k=s+1; k<e; k++){ // deciding where to cut the rod
            int cutCost = augCuts[e] - augCuts[s];
            int leftCost = f(s, k);
            int rightCost = f(k, e);

            best = Math.min(best, cutCost+leftCost+rightCost);
        }

        return memo[s][e] = best;
    }
}