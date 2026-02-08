class Solution{
    public int longestSubarray(int[] nums, int limit){
        // if(limit <= 0) return 0;

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int n = nums.length, maxLen = 1, l = 0;

        for(int r=0; r<n; r++){
            while(!max.isEmpty() && max.peekLast() < nums[r]){
                max.pollLast();
            }
            max.addLast(nums[r]);

            while(!min.isEmpty() && min.peekLast() > nums[r]){
                min.pollLast();
            }
            min.addLast(nums[r]);

            while(l < r && max.peekFirst() - min.peekFirst() > limit){
                if(!max.isEmpty() && max.peekFirst().equals(nums[l])){
                    max.pollFirst();
                }

                if(!min.isEmpty() && min.peekFirst().equals(nums[l])){
                    min.pollFirst();
                }

                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}