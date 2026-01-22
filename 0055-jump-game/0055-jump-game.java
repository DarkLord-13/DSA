class Solution{
    public boolean canJump(int[] nums){
        int n = nums.length, max = 0;

        for(int i=0; i<n; i++){
            if(max >= n - 1) return true;
            else if(i > max) return false;

            max = Math.max(max, i + nums[i]);
        }

        return false;
    }
}