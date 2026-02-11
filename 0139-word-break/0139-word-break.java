class Solution{

    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> dict){
        this.memo = new Boolean[s.length() + 1];
        Set<String> set = new HashSet<>(dict);
        return f(0, s, set);
    }

    private boolean f(int i, String s, Set<String> set){
        if(i >= s.length()) return memo[i] = true;
        if(memo[i] != null) return memo[i];

        for(int j=i; j<s.length(); j++){
            if(set.contains(s.substring(i, j + 1))){
                if(f(j + 1, s, set)) return memo[i] = true;
            }
        }

        return memo[i] = false;
    }
}