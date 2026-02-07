class Solution{
    public int characterReplacement(String str, int k){
        char[] s = str.toCharArray();

        int maxF = 0, maxLen = 0;
        int[] freq = new int[26];
        int l = 0, r = 0, n = s.length;

        while(r < n){
            int index = s[r] - 'A';
            freq[index]++;

            maxF = Math.max(maxF, freq[index]);

            int others = (r - l + 1) - maxF;

            if(others <= k) maxLen = Math.max(maxLen, r - l + 1);
            else{
                while(r - l + 1 - maxF > k){
                    index = s[l] - 'A';
                    freq[index]--;

                    maxF = 0;
                    for(int f: freq) maxF = Math.max(maxF, f);
                    l++;
                }
            }

            r++;
        }

        return maxLen;
    }
}