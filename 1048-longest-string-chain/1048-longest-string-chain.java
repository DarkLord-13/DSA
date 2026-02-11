class Solution{

    private int max;
    private Map<String, Integer> memo;

    public int longestStrChain(String[] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));
        max = 1;
        this.memo = new HashMap<>();
        
        for(String w: words) max = Math.max(max, f(w, set));

        return max;
    }

    private int f(String s, Set<String> set){
        if(s.length() == 1) return 1;
        if(memo.containsKey(s)) return memo.get(s);

        int best = 1;

        for(int i=0; i<s.length(); i++){
            String ns = s.substring(0, i) + s.substring(i + 1, s.length());
            if(set.contains(ns)){
                best = Math.max(best, 1 + f(ns, set));
            }
        }

        memo.put(s, best);
        return best;
    }
}