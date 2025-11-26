class Solution{
    public int smallestRepunitDivByK(int k){
        if(k % 2 == 0 || k % 5 == 0) return -1;
        long curr = 0;

        for(int i=0; i<k; i++){            
            curr = ((curr * 10) + 1) % k;
            if(curr == 0){
                return i + 1;
            }
        }

        return -1;
    }
}