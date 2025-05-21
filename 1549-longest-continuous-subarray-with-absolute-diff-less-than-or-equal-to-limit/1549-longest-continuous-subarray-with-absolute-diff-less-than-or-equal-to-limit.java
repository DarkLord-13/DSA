class Solution{
    public int longestSubarray(int[] nums, int limit){
        Deque<Integer> max = new LinkedList<>();
        Deque<Integer> min = new LinkedList<>();

        int l = 0;
        int n = nums.length;
        int res = 0;

        for(int r=0; r<n; r++){
            while(!max.isEmpty() && nums[r]>max.peekLast()){
                max.pollLast();
            }
            max.addLast(nums[r]);

            while(!min.isEmpty() && nums[r]<min.peekLast()){
                min.pollLast();
            }
            min.addLast(nums[r]);

            while(max.peekFirst()-min.peekFirst() > limit){
                if(max.peekFirst() == nums[l]){
                    max.pollFirst();
                }
                if(min.peekFirst() == nums[l]){
                    min.pollFirst();
                }     

                l++;           
            }

            res = Math.max(res, r-l+1);
        }

        return res;
    }
}