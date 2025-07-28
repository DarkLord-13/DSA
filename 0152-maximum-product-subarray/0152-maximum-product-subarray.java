class Solution{
    public int maxProduct(int[] nums){
        int n = nums.length;
        int lp = nums[0], rp = nums[n-1], mp = Math.max(lp, rp);

        for(int i=1; i<n; i++){
            if(lp == 0) lp = nums[i];
            else lp *= nums[i];
            
            if(rp == 0) rp = nums[n-i-1];
            else rp *= nums[n-i-1];            

            mp = Math.max(mp, Math.max(lp, rp));
        }

        return mp;
    }
}