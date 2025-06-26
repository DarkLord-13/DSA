class Solution{
    int[] augCuts;
    Integer[][] memo;
    public int minCost(int n, int[] cuts){
        int l = cuts.length;
        augCuts = new int[l + 2];
        augCuts[0] = 0;
        augCuts[l+1] = n;
        for(int i=1; i<=l; i++){
            augCuts[i] = cuts[i-1];
        }
        Arrays.sort(augCuts);
        memo = new Integer[l+2][l+2];

        return f(0, l+1);        
    }
    int f(int s, int e){
        if(s+1 == e){
            return 0;
        }
        if(memo[s][e] != null){
            return memo[s][e];
        }

        int minCost = Integer.MAX_VALUE;
        for(int cut=s+1; cut<e; cut++){
            int cost = (augCuts[e] - augCuts[s]) + f(s, cut) + f(cut, e);
            minCost = Math.min(minCost, cost); 
        }

        return memo[s][e] = minCost;
    }
}