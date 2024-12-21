class Solution{
    public int candy(int[] r){
        int n=r.length;
        int[] ans = new int[n];

        ans[0]=1;
        for(int i=1; i<n; i++){
            if(r[i]>r[i-1]) ans[i]=ans[i-1]+1;
            else ans[i]=1;
        }
        for(int i=n-2; i>=0; i--){
            if(r[i]>r[i+1]) ans[i]=Math.max(ans[i], ans[i+1]+1);
            else ans[i]=Math.max(ans[i], 1);
        }

        int sum=0;
        for(int i: ans) sum+=i;

        return sum;
    }
}