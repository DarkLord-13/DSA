class Solution{
    public int eraseOverlapIntervals(int[][] g){
        int n = g.length;

        if(n == 1){
            return 0;
        }

        Arrays.sort(g, (a, b)-> a[1] - b[1]);

        int rem = 0, prevEnd = g[0][1];
        for(int i=1; i<n; i++){
            if(g[i][0] < prevEnd){
                rem++;
            }
            else{
                prevEnd = g[i][1];
            }
        }

        return rem;
    }
}