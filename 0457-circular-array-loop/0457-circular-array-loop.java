class Solution{
    int n;
    int[] nums;
    public boolean circularArrayLoop(int[] nums){
        this.nums = nums;
        this.n = nums.length;

        for(int i=0; i<n; i++){
            if(nums[i] != 0){

                int slow = i;
                int fast = i;
                boolean isPos = nums[i] > 0;
                
                while(true){
                    int slowNext = nextIndex(slow);
                    if(nums[slowNext] == 0 || (nums[slowNext] > 0) != isPos) break;

                    int fastNext = nextIndex(fast);
                    if(nums[fastNext] == 0 || (nums[fastNext] > 0) != isPos) break;

                    int fastFastNext = nextIndex(fastNext);
                    if(nums[fastFastNext] == 0 || (nums[fastFastNext] > 0) != isPos) break;

                    slow = slowNext;
                    fast = fastFastNext;

                    if(slow == fast){
                        if(slow == nextIndex(slow)){
                            break;
                        }
                        
                        return true;
                    }
                }

                int j = i;
                while(nums[j] != 0 && (nums[j] > 0) == isPos){
                    int next = nextIndex(j);
                    nums[j] = 0;
                    j = next;
                }
            }            
        }

        return false;
    }

    private int nextIndex(int curr){
        int next = (curr + nums[curr]) % n;
        if(next < 0) next += n;

        return next;
    }
}