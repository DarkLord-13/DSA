class Solution{
    public int lengthOfLIS(int[] nums){
        int lis = 1;
        int n = nums.length;
        int[] length = new int[n];
        Arrays.fill(length, 1);

        for(int curr=0; curr<n; curr++){
            for(int prev=0; prev<curr; prev++){

                if(nums[prev] < nums[curr]){ // LIS
                    length[curr] = Math.max(length[curr], length[prev] + 1);
                }         
            }
            lis = Math.max(lis, length[curr]);
        }
        // System.out.println(Arrays.toString(length));

        return lis;
    }
}