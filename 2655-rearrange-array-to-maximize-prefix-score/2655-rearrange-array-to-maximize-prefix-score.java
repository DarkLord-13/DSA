class Solution{
    public int maxScore(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        long[] pre = new long[n];

        pre[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            pre[i] = pre[i+1] + nums[i];
        }

        int c = 0;
        for(long i: pre){
            if(i > 0){
                c++;
            }
        }

        return c;
    }
}