class Solution {
    public int[] twoSum(int[] og, int target){
        int[] nums = Arrays.copyOf(og, og.length); 
        Arrays.sort(nums); 
        int i=0, j = nums.length-1;

        while(i<j){
            int sum = nums[i] + nums[j];
            if(sum<target) i++;
            else if(sum>target) j--;
            else break;
        } 
        int a = nums[i], b = nums[j];
        boolean fa = true, fb = true;
        for(int ind=0; ind<og.length; ind++){
            if(og[ind]==a&&fa){
                i = ind;
                fa = false;
            }
            else if(og[ind]==b&&fb){
                j = ind;
                fb = false;
            }
        }

        int[] ret = new int[2];
        ret[0] = i; ret[1] = j;
        return ret;
    }
}