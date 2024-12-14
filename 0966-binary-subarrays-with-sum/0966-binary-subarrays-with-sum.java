class Solution{
    public int numSubarraysWithSum(int[] a, int g){
        int n = a.length, c = 0;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum+=a[j];
                if(sum==g) c++;
            }            
        }

        return c;
    }
}