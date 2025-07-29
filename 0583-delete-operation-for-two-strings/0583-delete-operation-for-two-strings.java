class Solution{
    char[] a, b;
    int n1, n2;
    int[][] memo;
    public int minDistance(String word1, String word2){
        this.a = word1.toCharArray();
        this.b = word2.toCharArray();
        this.n1 = a.length;
        this.n2 = b.length;
        this.memo = new int[n1][n2];

        for(int i=0; i<n1; i++) Arrays.fill(memo[i], -1);

        return f(0, 0);
    }
    int f(int i, int j){
        if(i >= n1 && j >= n2){
            return 0;
        }
        if(i >= n1){
            return n2 - j;
        }
        if(j >= n2){
            return n1 - i;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        int p = 999999;
        if(a[i] == b[j]){
            p = f(i+1, j+1);
        }

        int q = 1 + f(i+1, j);

        int r = 1 + f(i, j+1);

        return memo[i][j] = Math.min(p, Math.min(q, r));
    }
}