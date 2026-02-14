class Solution{
    public int minTime(int[] nums, int k){
        int l = 0, h = 0;
        for(int num: nums){
            l = Math.max(l, num);
            h += num;
        }
        
        while(l <= h){
            int max = l + (h - l) / 2;
            int painter = 1, sum = 0;
            
            for(int num: nums){
                sum += num;
                
                if(sum > max){
                    sum = num;
                    painter++;
                }
            }
            
            if(painter <= k) h = max - 1;
            else l = max + 1;
        }
        
        return l;
    }
}
