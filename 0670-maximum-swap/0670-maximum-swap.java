class Solution{
    public int maximumSwap(int num){
        char[] nums = Integer.toString(num).toCharArray();
        int n = nums.length;

        for(int i=0; i<n; i++){
            char max = nums[i];
            int maxIndex = i;

            for(int j=i+1; j<n; j++){
                if(nums[j] >= max){
                    max = nums[j];
                    maxIndex = j;
                }
            }

            if(i != maxIndex && max != nums[i]){
                swap(i, maxIndex, nums);
                String ret = new String(nums);
                return Integer.parseInt(ret);
            }
        }

        return num;
    }

    private void swap(int i, int j, char[] nums){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}