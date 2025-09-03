class Solution{
    private int n;
    private String s;
    private Boolean[][] memo;
    public boolean wordBreak(String s, List<String> dict){
        this.n = s.length();
        this.s = s;
        this.memo = new Boolean[n][n];
        HashSet<String> set = new HashSet<>(dict);

        return f(0, s.length() - 1, set);
    }
    boolean f(int i, int j, HashSet<String> set){
        if(i >= n) return true;
        if(j >= n) return false;
        if(memo[i][j] != null) return memo[i][j];

        for(int k=i; k<=j; k++){
            if(set.contains(s.substring(i, k + 1))){
                boolean ret = f(k + 1, j, set);
                if(ret) return memo[i][j] = true;
            }
        }

        return memo[i][j] = false;
    }
}