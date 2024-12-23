class Solution{
    public void merge(int[] a, int m, int[] b, int n){        
        int i=m-1, j=n-1, put=m+n-1;

        while(i>=0&&j>=0){
            if(a[i]>=b[j]){
                a[put] = a[i];
                i--;
            }
            else{
                a[put] = b[j];
                j--;
            }
            put--;
        }
        while(i>=0){
            a[put] = a[i];
            put--;
            i--;
        }
        while(j>=0){
            a[put] = b[j];
            put--;
            j--;
        }
    }
}