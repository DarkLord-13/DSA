class Solution{
    public List<String> findAllConcatenatedWordsInADict(String[] words){
        Set<String> set = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();

        for(String s: words){
            set.remove(s);
            int n = s.length();

            if(wordBreak(0, n - 1, s, n, set, new Boolean[n][n])){
                res.add(s);
            }

            set.add(s);
        }

        return res;
    }

    private boolean wordBreak(int i, int j, String s, int n, Set<String> set, Boolean[][] memo){
        if(j >= n) return false;
        if(i >= n) return true;
        if(memo[i][j] != null) return memo[i][j];

        for(int k=i; k<=j; k++){
            if(set.contains(s.substring(i, k + 1))){
                if(wordBreak(k + 1, j, s, n, set, memo)){
                    return memo[i][j] = true;
                }
            }
        }

        return memo[i][j] = false;
    }
}