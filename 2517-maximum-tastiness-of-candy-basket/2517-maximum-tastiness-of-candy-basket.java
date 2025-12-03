class Solution{
    public int maximumTastiness(int[] p, int k){
        int n = p.length;
        Arrays.sort(p);
        if(p[0] == p[n - 1]) return 00;

        int l = 0, h = p[n - 1] - p[0], ans = -1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(isPossible(mid, p, k)){
                ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }    

        return ans == -1 ? 0 : ans + 1;    
    }

    private boolean isPossible(int mid, int[] p, int k){
        int n = p.length, count = 0, l = -1;

        for(int i=0; i<n; i++){
            if(l == -1 || p[i] - l > mid){
                l = p[i];
                count++;

                if(count >= k) return true;
            }
        }

        return false;
    }
}