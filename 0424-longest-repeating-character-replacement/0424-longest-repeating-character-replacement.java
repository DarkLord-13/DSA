class Solution{
    public int characterReplacement(String s, int k){
        int l=0, r=0, n=s.length(), maxFreq=0, maxLen=0;
        int[] arr = new int[26];

        while(r<n){
            char c = s.charAt(r);
            arr[c-'A']++;
            int currLen = r-l+1;
            maxFreq = Math.max(maxFreq, arr[c-'A']);

            while(l<r && !valid(currLen, maxFreq, k)){
                arr[s.charAt(l)-'A']--;
                l++;
                currLen = r-l+1;
                for(int i: arr) maxFreq = Math.max(maxFreq, i);
            }            
            
            maxLen = Math.max(maxLen, currLen);            
            r++;
        }

        return maxLen;
    }
    boolean valid(int currLen, int maxFreq, int k){
        if(currLen-maxFreq > k) return false;
        return true;
    }
}