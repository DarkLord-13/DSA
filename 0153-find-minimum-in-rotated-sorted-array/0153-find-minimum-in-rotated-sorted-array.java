class Solution {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        int ans = nums[0];

        while (l <= h) {
            int mid = l + ((h - l) >> 1);

            if (nums[l] <= nums[mid]) {
                ans = Math.min(ans, nums[l]);
                l = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                h = mid - 1;
            }
        }

        return ans;
    }
}