class Solution{
    public int eraseOverlapIntervals(int[][] a){
        int n = a.length;
        Arrays.sort(a, (x, y)->Integer.compare(x[1], y[1]));

        int rem = 0;
        int e = a[0][1];

        for(int i=1; i<n; i++){
            if(a[i][0]<e){
                rem++;
            }
            else e = a[i][1];
        }

        return rem;
    }
}