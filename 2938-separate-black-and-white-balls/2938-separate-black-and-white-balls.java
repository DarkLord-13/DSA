class Solution{
    public long minimumSteps(String s){
        int l = 0, r = s.length() - 1;
        char[] arr = s.toCharArray();
        long swaps = 0;

        while(l < r){
            if(arr[l] == '1'){
                if(arr[r] == '1'){
                    r--;
                }
                else{
                    swaps += (r - l);
                    r--;
                    l++;
                }
            }
            else l++;
        }

        return swaps;        
    }
}