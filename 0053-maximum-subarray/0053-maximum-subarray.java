class Solution{
    public int maxSubArray(int[] a){
        int sum = a[0];
        int max = a[0];

        for(int i=1; i<a.length; i++){
            if(sum < 0){
                sum = 0;
            }
            
            sum += a[i];  
            max = Math.max(max, sum);                      
        }

        return Math.max(max, sum);
    }
}