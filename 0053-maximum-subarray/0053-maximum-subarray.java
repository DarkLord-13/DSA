class Solution{
    public int maxSubArray(int[] nums){
        int sum = nums[0], l = nums.length, cs = 0;
        for(int i=0; i<l; i++){
            cs+=nums[i];
            if(nums[i]>cs) cs = nums[i];
            sum = Math.max(sum, cs);
        }

        return sum;
    }
}