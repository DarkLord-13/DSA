class Solution{
    public boolean canJump(int[] a){
        int n=a.length, maxi=0;

        for(int i=0; i<n; i++){
            if(i>maxi) return false;
            //if(maxi>=n) return true;
            maxi = Math.max(maxi, i+a[i]);
        }

        return true;
    }
}