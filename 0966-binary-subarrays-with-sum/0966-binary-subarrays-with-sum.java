class Solution{
    int[] a; int n;
    public int numSubarraysWithSum(int[] ax, int g){
        a = ax; n = a.length;        

        return subArrays(g)-subArrays(g-1);
    }
    int subArrays(int goal){
        if(goal<0) return 0;

        int l=0, r=0, sum=0, c=0;

        while(r<n){
            sum+=a[r];
            while(sum>goal){
                sum-=a[l];
                l++;
            }

            c+=(r-l+1);
            r++;
        }

        return c;
    }
}