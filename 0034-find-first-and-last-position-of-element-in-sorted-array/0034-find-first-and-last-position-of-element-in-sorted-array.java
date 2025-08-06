class Solution{
    private int[] nums;
    private int target, n;
    public int[] searchRange(int[] nums, int target){
        this.nums = nums;
        this.n = nums.length;
        this.target = target;

        return new int[] {lowerBound(), upperBound()};
    }
    int lowerBound(){
        int l = 0, h = n-1, ans = -1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(nums[mid] >= target){
                if(nums[mid] == target) ans = mid;
                h = mid - 1;
            }
            else{                
                l = mid + 1;
            }
        }

        return ans;
    }

    int upperBound(){
        int l = 0, h = n-1, ans = -1;

        while(l <= h){
            int mid = (l + h) >> 1;

            if(nums[mid] <= target){
                if(nums[mid] == target) ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }

        return ans;
    }
}