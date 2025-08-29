class Solution{
    public int maxProfit(int[] p){
        int max = 0;
        int n = p.length;
        int cp = p[n - 1];

        for(int i=n-1; i>=0; i--){
            max = Math.max(max, cp - p[i]);

            cp = Math.max(cp, p[i]);
        }

        return max;
    }
}