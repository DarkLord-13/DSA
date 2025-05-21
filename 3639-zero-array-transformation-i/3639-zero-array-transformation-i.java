class Solution{
    public boolean isZeroArray(int[] nums, int[][] q){
        int n = nums.length;
        int[] op = new int[n+1];

        for(int i=0; i<q.length; i++){
            int s = q[i][0], e = q[i][1];
            op[s]--;
            op[e+1]++;
        } 

        int prefix = 0;
        for(int i=0; i<n; i++){
            prefix += op[i];
            nums[i] += prefix;
        } 

        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                return false;
            }
        } 

        return true;
    }
}