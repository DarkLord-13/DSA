class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, h = nums.length - 1;
        int[] sq = new int[nums.length];
        int i = 0, j = nums.length - 1;

        while(l <= h){
            if(nums[l] < 0){
                if(-1*nums[l] >= nums[h]){
                    sq[j] = nums[l] * nums[l];
                    l++;
                    j--;
                }
                else{
                    sq[j] = nums[h] * nums[h];
                    h--;
                    j--;
                }
            }
            else{
                sq[i] = nums[l] * nums[l];
                l++;
                i++;
            }
        }

        return sq;
    }
}