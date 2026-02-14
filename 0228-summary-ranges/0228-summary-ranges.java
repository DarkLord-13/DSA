class Solution{
    public List<String> summaryRanges(int[] nums){
        if(nums.length == 0) return List.of();
        
        int prev = 0;
        List<String> l = new ArrayList<>();

        for(int curr=1; curr<nums.length; curr++){
            if(nums[curr] != nums[curr - 1] + 1){
                if(curr > prev + 1) l.add(nums[prev] + "->" + nums[curr - 1]);
                else l.add(nums[prev] + "");

                prev = curr;
            }
        }

        if(prev == nums.length - 1) l.add(nums[prev] + "");
        else l.add(nums[prev] + "->" + nums[nums.length - 1]);

        return l;
    }
}