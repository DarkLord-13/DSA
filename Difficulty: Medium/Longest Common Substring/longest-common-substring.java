class Solution {
    public int longCommSubstr(String a, String b) {
        int al = a.length(), bl = b.length(), max = 0;
        int[][] dp = new int[al + 1][bl + 1];
        
        for (int i=0; i<al; i++) {
            for (int j=0; j<bl; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        
        return max;
    }
}