import java.util.*;

class Solution {
    public List<Integer> findCoins(int[] numWays) {
    int n = numWays.length;
    long[] myWays = new long[n + 1];
    myWays[0] = 1;

    List<Integer> res = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
        // If `myWays[x] == numWays[x]`, move on.
        if (myWays[i] == numWays[i - 1]) continue;

        // If `myWays[x] + 1 == numWays[x]` → add that value as a coin in our basket and update `myWays`, so `myWays[x...n]` accounts for ways with the new coin.
        if (numWays[i - 1] - myWays[i] == 1) {
            res.add(i);
            for (int j = i; j <= n; j++) {
                myWays[j] += myWays[j - i];
            }

        // If `myWays[x] + 1 < numWays[x]` → no solution. (*see below for why)
        } else {
            return Collections.emptyList();
        }
    }
    return res;
}
}
