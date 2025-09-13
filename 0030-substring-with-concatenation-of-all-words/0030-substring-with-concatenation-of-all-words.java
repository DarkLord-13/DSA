class Solution{
    public List<Integer> findSubstring(String s, String[] words){
        HashMap<String, Integer> actual = new HashMap<>();
        for(String w: words){
            actual.put(w, actual.getOrDefault(w, 0) + 1);
        }
        System.out.println(actual);

        int req = words.length;
        int wordLen = words[0].length();
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<wordLen; i++){
            int sat = 0;                   
            int l = i, r = i, count = 0;
            HashMap<String, Integer> current = new HashMap<>();
            
            while(r + wordLen <= s.length()){

                String w = s.substring(r, r + wordLen);
                r += wordLen;

                if(actual.containsKey(w)){
                    current.put(w, current.getOrDefault(w, 0) + 1);
                    count++;

                    while(current.get(w) > actual.get(w)){
                        String rem = s.substring(l, l + wordLen);
                        l += wordLen;
                        current.put(rem, current.get(rem) - 1);
                        count--;
                    }

                    if(count == req){
                        ans.add(l);
                        String rem = s.substring(l, l + wordLen);
                        l += wordLen;
                        current.put(rem, current.get(rem) - 1);
                        count--;
                    }                   
                }
                else{
                    current.clear();
                    l = r;
                    count = 0;
                }            
            }
        }

        return ans;
    }
}