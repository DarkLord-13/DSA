class Solution{
    public int threeSumClosest(int[] a, int t){
        int n = a.length;
        Arrays.sort(a);
        int minDiff = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0; i<n-2; i++){
            for(int l=i+1; l<n-1; l++){
                for(int r=l+1; r<n; r++){
                    int diff = Math.abs(a[i] + a[l] + a[r] - t);
                    if(diff < minDiff){
                        sum = a[i] + a[l] + a[r];
                        minDiff = diff;
                    }
                }
            }
        }

        return sum;
    }
}