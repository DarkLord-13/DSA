class Solution{
    public int numSubarrayProductLessThanK(int[] nums, int k){
        int l = 0, p = 1, subs = 0, n = nums.length;

        for(int r=0; r<n; r++){
            p *= nums[r];
            
            while(l <= r && p >= k){
                p /= nums[l];
                l++;
            }

            subs += (r - l + 1);
        }

        return subs;
    }
}