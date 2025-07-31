class Solution {
    int n1, n2;
    String s1, s2;
    String[][] dp; // Memoization table

    public int minimumDeleteSum(String s1x, String s2x) {
        s1 = s1x;
        s2 = s2x;
        n1 = s1.length();
        n2 = s2.length();

        // Initialize memoization table with null (to check for uncomputed states)
        dp = new String[n1 + 1][n2 + 1];

        // Compute LCS
        String lcs = f(0, 0);
        System.out.println("LCS: " + lcs);

        // Compute ASCII sums
        int sum1 = getAsciiSum(s1);
        int sum2 = getAsciiSum(s2);
        int sumLCS = getAsciiSum(lcs);

        return sum1 + sum2 - (2 * sumLCS);
    }

    // Recursive function to find LCS with memoization
    String f(int i, int j) {
        if (i >= n1 || j >= n2) {
            return "";
        }

        // Return cached result if already computed
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        String a = "";
        if (s1.charAt(i) == s2.charAt(j)) {
            a = s1.charAt(i) + f(i + 1, j + 1);
        }
        String b = f(i + 1, j);
        String c = f(i, j + 1);

        // Determine the best LCS based on length & ASCII sum
        int maxLen = Math.max(a.length(), Math.max(b.length(), c.length()));
        int maxAscii = getAsciiSum(a);
        String ret = a;

        if (b.length() == maxLen && getAsciiSum(b) > maxAscii) {
            maxAscii = getAsciiSum(b);
            ret = b;
        }
        if (c.length() == maxLen && getAsciiSum(c) > maxAscii) {
            ret = c;
        }

        return dp[i][j] = ret; // Store computed result in memo table
    }

    // Helper function to compute ASCII sum of a string
    int getAsciiSum(String str) {
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}
