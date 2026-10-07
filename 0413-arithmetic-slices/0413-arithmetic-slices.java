class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            nums[i] = nums[i + 1] - nums[i];
        }

        int l = 1, arithmeticSubs = 0;
        for (int i=1; i<n-1; i++) {
            if (nums[i] == nums[i - 1]) {
                l++;
            } else {
                l -= 1;
                if (l > 0) {
                    arithmeticSubs += ((l * (l + 1)) / 2);
                }

                l = 1;
            }
        }

        l -= 1;
        if (l > 0) {
            arithmeticSubs += (l * (l + 1)) / 2;
        }

        return arithmeticSubs;
    }
}