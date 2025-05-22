class Solution{
    public int minOperations(int[] a, int x){
        int n = a.length;
        int total = 0;
        for(int i: a){
            total += i;
        }
        
        int l = 0, r = 0;
        int max = -1, sum = 0, needed = total-x;
        while(r < n){
            sum += a[r];           
            while(sum > needed && l <= r){
                sum -= a[l];
                l++;
            }

            if(sum == needed){
                max = Math.max(max, r-l+1);
            }

            r++;
        }

        if(max < 0){
            return max;
        }
        return n-max;
    }
}