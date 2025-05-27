class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 1, right = (long)1e16;
        long ans = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canComplete(mid, workerTimes, mountainHeight)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private boolean canComplete(long maxTime, int[] times, int targetHeight) {
        long total = 0;
        for (int t : times) {
            // Solve h(h + 1) <= 2 * maxTime / t
            long K = (2 * maxTime) / t;
            long h = (long)(Math.sqrt(1 + 4 * (double)K) - 1) / 2;
            total += h;
            if (total >= targetHeight) return true;
        }
        return total >= targetHeight;
    }
}
