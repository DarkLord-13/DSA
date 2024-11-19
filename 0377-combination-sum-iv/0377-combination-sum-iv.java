class Solution{
    int[] nums; int t, n, c=0; Integer[] memo;
    public int combinationSum4(int[] numsx, int tx){
        nums = numsx; t = tx; n = nums.length;
        memo = new Integer[t];

        return f(0);
    }
    int f(int s){
        if(s==t) return 1;        
        if(s>t) return 0;
        if(memo[s]!=null) return memo[s];

        int a = 0;
        for(int i: nums) 
            a += f(i+s);

        return memo[s] = a;
    }
}