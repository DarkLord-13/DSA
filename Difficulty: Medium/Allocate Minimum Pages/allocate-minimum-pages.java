class Solution{
    public static int findPages(int[] b, int k){
        int n = b.length;
        if(k > n){
            return -1;
        }

        int l = Integer.MIN_VALUE;
        int h = 0;
        for(int pages: b){
            l = Math.max(l, pages);
            h += pages;
        }
        
        while(l <= h){
            int mid = (l+h) >> 1; //System.out.println(mid);
            int curr = 0, s = 1;
            
            for(int i=0; i<n; i++){
                if(curr+b[i] > mid){ //System.out.println(curr);
                    curr = b[i];
                    s++;
                }
                else{
                    curr += b[i];
                }
            }

            if(s <= k){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        } 
        
        return l;
    }
}