class Solution{
    public int maxFrequency(int[] nums, int k){
        int n = nums.length;
        int kCount = 0;

        for(int i: nums){
            if(i == k){
                kCount++;
            }
        }

        int[] mod = new int[n];
        int max = 0;

        for(int i=1; i<=50; i++){
            for(int j=0; j<n; j++){
                if(nums[j] == k){
                    mod[j] = -1;
                }
                else if(nums[j] == i){
                    mod[j] = 1;
                }
                else{
                    mod[j] = 0;
                }
            }

            max = Math.max(max, kadane(mod));
        }

        return max + kCount;
    }
    int kadane(int[] arr){
        int sum = 0;
        int max = 0;

        for(int i: arr){
            sum += i;

            if(sum < 0){
                sum = 0;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}