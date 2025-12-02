class Solution{
    public int leastInterval(char[] tasks, int n){
        int[] arr = new int[26];
        for(char c: tasks) arr[c - 'A']++;

        int maxFreq = -1, maxFreqCount = 0;
        for(int i=0; i<26; i++){
            int num = arr[i];
            if(num > maxFreq){
                maxFreq = num;
                maxFreqCount = 1;
            }
            else if(num == maxFreq) maxFreqCount++;
        }    

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxFreqCount);
        
    }
}