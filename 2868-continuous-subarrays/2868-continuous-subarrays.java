import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        long count = 0;

        for (int j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Shrink window if diff > 2
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
            }

            // All subarrays ending at j with start in [i...j] are valid
            count += (j - i + 1);
        }

        return count;
    }
}
