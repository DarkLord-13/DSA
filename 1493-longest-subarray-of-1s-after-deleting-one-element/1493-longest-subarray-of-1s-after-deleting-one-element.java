class Solution{
    public int longestSubarray(int[] nums){
        int l = 0, n = nums.length;
        int max = 0, k = 1, z = 0;

        boolean containsZero = false;
        for(int num: nums){
            if(num == 0){
                containsZero = true;
                break;
            }
        }

        if(!containsZero) return n - 1;

        for(int r=0; r<n; r++){
            if(nums[r] == 0) z++;

            while(l < r && z > k){
                if(nums[l] == 0) z--;

                l++;
            }

            max = Math.max(max, r - l + 1 - z);
        }

        return max;
    }
}