class Solution{
    public int maxScore(int[] a, int k){
        int n = a.length, ls = 0, rs = 0;
        for(int i=0; i<k; i++){
            ls+=a[i];
        }

        int max = ls, ri = n-1;
        for(int i=k-1; i>=0; i--){
            ls-=a[i];
            rs+=a[ri]; ri--;
            max = Math.max(max, ls+rs);
        }

        return max;
    }
}