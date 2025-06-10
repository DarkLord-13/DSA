class Solution{
    public int minimumDeletions(String word, int k){
        Map<Character, Integer> charFreq = new HashMap<>();
        int max = 0;
        for(char c: word.toCharArray()){
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
            max = Math.max(max, charFreq.get(c));
        } // System.out.println(charFreq);

        int minDelete = word.length();

        for(int i=0; i<=max; i++){
            int delete = 0;
            int minw = i, maxw = i+k;
            for(Map.Entry<Character, Integer> entry: charFreq.entrySet()){
                int freq = entry.getValue();
                
                if(freq > maxw){
                    delete += (freq - maxw);
                }
                else if(freq < minw){
                    delete += freq;
                }
            }

            minDelete = Math.min(minDelete, delete);
        }

        return minDelete;
    }
}