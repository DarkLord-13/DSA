class Solution{

    private int[] nums, og;
    private Random rand;

    public Solution(int[] nums){
        this.nums = nums;
        this.og = nums.clone();
        this.rand = new Random();
    }
    
    public int[] reset(){
        nums = og.clone();

        return nums;
    }
    
    public int[] shuffle(){
        int n = nums.length;

        for(int i=0; i<n; i++){
            int j = i + rand.nextInt(n - i);
            swap(i, j);
        }

        return nums;
    }

    private void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */