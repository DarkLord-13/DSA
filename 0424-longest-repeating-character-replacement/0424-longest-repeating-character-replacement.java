class Solution{
    public int characterReplacement(String str, int k){
        char[] s = str.toCharArray();
        int l = 0, r = 0, maxLen = 0, n = s.length, maxFreq = 0;
        int[] freq = new int[26];

        while(r < n){
            char c = s[r];
            freq[c - 'A']++;
            int currLen = r - l + 1;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            while(l < r && (currLen - maxFreq > k)){
                freq[s[l] - 'A']--;
                currLen--;
                for(int f: freq) maxFreq = Math.max(maxFreq, f);
                l++;
            }

            maxLen = Math.max(maxLen, currLen);
            r++;
        }

        return maxLen;
    }
}