class Solution{
    public int kthSmallest(int[][] g, int k){
        int left = k-1;
        int n = g.length;
        int l = g[0][0], h = g[n-1][n-1];

        while(l <= h){
            int mid = (l+h) >> 1;

            int lse = 0;
            for(int i=0; i<n; i++){
                lse += lessThanMid(g[i], mid);
            }

            if(lse <= left){
                l = mid+1; 
            }
            else{
                h = mid-1;
            }
        }

        return l;
    }
    int lessThanMid(int[] arr, int num){
        int l = 0, h = arr.length-1;
        while(l <= h){
            int mid = (l+h) >> 1;

            if(arr[mid] <= num){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }

        return l;
    }
}