class Solution{
    public int[] nextGreaterElements(int[] a){
        int n = a.length; int[] ret = new int[n];
        int maxi = 0;
        for(int i=0; i<n; i++){
            if(a[i]>a[maxi]){
                maxi = i;
            }

            int j = i+1;
            while(j!=i){
                if(j==n){
                    if(i!=0) j=0;
                    else break;
                }
                if(a[j]>a[i]){
                    ret[i] = a[j];
                    break;
                }
                j++;
            }
        } //System.out.println(a[maxi]);
        for(int i=0; i<n; i++){
            if(a[i]==a[maxi]) ret[i] = -1;
        }
        //ret[maxi] = -1;

        return ret;
    }
}