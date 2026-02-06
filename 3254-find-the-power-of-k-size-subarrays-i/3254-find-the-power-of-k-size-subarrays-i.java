class Solution{
    public int[] resultsArray(int[] nums, int k){
        if(k == 1) return nums;

        int n = nums.length, sub = 1;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);

        for(int i=1; i<n; i++){
            if(nums[i] == nums[i - 1] + 1){
                sub++;

                if(sub >= k) ans[i - k + 1] = nums[i];
            }
            else sub = 1;
        }

        return ans;
    }
}