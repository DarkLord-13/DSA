class Solution{
    public int findMin(int[] a){
        int n = a.length;        
        int l = 0, h = n-1;

        while(l < h){
            int mid = (l + h) >> 1;

            if(a[mid] < a[h]){
                h = mid;
            }
            else{
                l = mid + 1;
            }
        }

        return a[l];
    }
}