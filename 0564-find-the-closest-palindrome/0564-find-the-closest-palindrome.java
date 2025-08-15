class Solution {
    public String nearestPalindromic(String n) {
        long self = Long.parseLong(n);
        int len = n.length();
        
        // Edge candidates
        long smallerEdge = (long)Math.pow(10, len - 1) - 1; // like 999 for 1000
        long biggerEdge = (long)Math.pow(10, len) + 1;      // like 10001 for 9999

        long prefix = Long.parseLong(n.substring(0, (len + 1) / 2));

        // Main candidates from prefix
        long samePrefix = makePalindrome(prefix, len % 2 == 0);
        long smallerPrefix = makePalindrome(prefix - 1, len % 2 == 0);
        long biggerPrefix = makePalindrome(prefix + 1, len % 2 == 0);

        // Put all in a set to avoid duplicates
        Set<Long> candidates = new HashSet<>();
        candidates.add(smallerEdge);
        candidates.add(biggerEdge);
        candidates.add(samePrefix);
        candidates.add(smallerPrefix);
        candidates.add(biggerPrefix);

        long ans = -1;
        for (long cand : candidates) {
            if (cand == self) continue; // skip itself
            if (ans == -1 ||
                Math.abs(cand - self) < Math.abs(ans - self) ||
                (Math.abs(cand - self) == Math.abs(ans - self) && cand < ans)) {
                ans = cand;
            }
        }
        return String.valueOf(ans);
    }

    private long makePalindrome(long prefix, boolean evenLen) {
        String s = String.valueOf(prefix);
        StringBuilder sb = new StringBuilder(s);
        if (evenLen) {
            sb.append(new StringBuilder(s).reverse());
        } else {
            sb.append(new StringBuilder(s.substring(0, s.length() - 1)).reverse());
        }
        return Long.parseLong(sb.toString());
    }
}
