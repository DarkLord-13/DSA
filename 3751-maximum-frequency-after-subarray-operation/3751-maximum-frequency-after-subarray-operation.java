class Solution {
    public int maxFrequency(int[] nums, int k) {
        int orig = 0;           // count of original k
        int maxGain = 0;        // best gain from one operation

        // Count how many k's already exist
        for (int num : nums) {
            if (num == k) orig++;
        }

        // Try converting every other number m to k
        for (int m = 1; m <= 50; m++) {
            if (m == k) continue;
            int current = 0, maxCurrent = 0;

            for (int num : nums) {
                // +1 if we can convert m → k
                // -1 if we would lose an existing k
                // 0 otherwise
                current += (num == m) ? 1 : (num == k) ? -1 : 0;

                // Reset if we go below 0 — Kadane's trick
                current = Math.max(current, 0);

                // Track max gain for this m
                maxCurrent = Math.max(maxCurrent, current);
            }

            // Update overall max gain
            maxGain = Math.max(maxGain, maxCurrent);
        }

        return orig + maxGain;
    }
}
