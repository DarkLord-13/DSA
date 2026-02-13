class Solution{
    public int subarraySum(int[] arr){
        int n = arr.length;
        int total = 0;

        for(int i=0; i<n; i++){
            total += arr[i] * (i + 1) * (n - i);
        }

        return total;
    }
}
