class Solution{
    public int findDuplicate(int[] nums){
        int n = nums.length;
        int i = 0;

        while(i < n){
            int currNum = nums[i];

            if(currNum != i + 1){
                int actualIndex = currNum - 1;
                if(nums[actualIndex] == currNum){
                    return currNum;
                }
                else{
                    swap(i, actualIndex, nums);
                }
            }
            else{
                i++;
            }
        }

        return -1;
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}