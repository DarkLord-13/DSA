class Solution{
    public boolean checkArray(int[] nums, int k) {
    int n = nums.length;
    int[] diff = new int[n + 1]; // Difference array for range updates
    int curr = 0; // Current value being subtracted at index i

    for (int i = 0; i < n; i++) {
        curr += diff[i]; // Apply all previous operations at this index

        int need = nums[i] - curr;
        if (need < 0) return false; // Over-decremented, not valid

        if (need > 0) {
            if (i + k > n) return false; // Out of bounds, can't apply

            // Schedule the operation
            curr += need;
            diff[i + k] -= need; // Will cancel this `need` after k steps
        }
    }

    return true;
}

    void print(int[] nums){
        for(int i: nums){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}