class Solution{
    public int singleNonDuplicate(int[] a){
        int n = a.length;
        if(n == 1){
            return a[0];
        }
        int l = 0;
        int h = n-1;

        while(l <= h){
            int mid = (l+h) >> 1;
            if(mid%2 == 0){
                if(mid < n-1 && a[mid] == a[mid+1]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
            else{
                if(a[mid] == a[mid-1]){
                    l = mid+1;
                }
                else{
                    h = mid-1;
                }
            }
        }

        return a[l];
    }
}