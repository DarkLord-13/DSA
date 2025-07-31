class Solution{
    private char[] s;
    private int n;
    private Integer[][] memo;
    public int minInsertions(String str){
        this.s = str.toCharArray();
        this.n = str.length();
        this.memo = new Integer[n][n];

        return f(0, n-1);
    }
    int f(int i, int j){
        if(i >= j){
            return 0;
        }
        if(memo[i][j] != null){
            return memo[i][j];
        }

        int a = 999999;
        if(s[i] == s[j]){
            a = f(i+1, j-1);
        }

        int b = 1 + f(i+1, j);
        
        int c = 1 + f(i, j-1);

        return memo[i][j] = Math.min(a, Math.min(b, c));
    }
}