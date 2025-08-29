class Solution{
    public void sortColors(int[] nums){
        int n = nums.length;
        int l = 0, h = n - 1;
        int i = 0;
        
        while(i <= h){
            if(nums[i] == 0){
                swap(l, i, nums);
                l++;
                i++;
            }
            else if(nums[i] == 2){
                swap(i, h, nums);
                h--;
            }
            else{
                i++;
            }
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}