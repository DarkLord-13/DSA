class Solution{
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ll = new ArrayList<>();
        int n = nums.length;
        if(n < 4) return ll;

        Arrays.sort(nums);

        for(int i=0; i<n-3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j=i+1; j<n-2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1, r = n - 1;

                while(l < r){
                    long sum = nums[i]*1L + nums[j] + nums[l] + nums[r];

                    if(sum < target) l++;
                    else if(sum > target) r--;
                    else{
                        ll.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;

                        l++;
                        r--;
                    }
                }
            }
        }

        return ll;
    }
}