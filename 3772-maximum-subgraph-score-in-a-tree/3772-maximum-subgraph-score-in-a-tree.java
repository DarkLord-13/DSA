public class Solution {
    int n;
    List<Integer>[] adj;
    int[] val;   // +1 for good, -1 for bad
    int[] dp;    // best score inside subtree rooted at node (only using children)
    int[] up;    // best contribution coming from parent side (outside the subtree)
    int[] ans;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; ++i) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        val = new int[n];
        for (int i = 0; i < n; ++i) val[i] = (good[i] == 1) ? 1 : -1;

        dp = new int[n];
        up = new int[n];
        ans = new int[n];

        // 1) compute dp[] with a DFS from root 0
        dfs1(0, -1);

        // 2) compute up[] and final answers with reroot DFS
        up[0] = 0;
        dfs2(0, -1);

        return ans;
    }

    // post-order: dp[u] = val[u] + sum(max(0, dp[child]))
    private void dfs1(int u, int p) {
        dp[u] = val[u];
        for (int v : adj[u]) {
            if (v == p) continue;
            dfs1(v, u);
            dp[u] += Math.max(0, dp[v]);
        }
    }

    // pre-order reroot: up[v] = max(0, up[u] + dp[u] - max(0, dp[v]))
    // and ans[u] = dp[u] + max(0, up[u])
    private void dfs2(int u, int p) {
        ans[u] = dp[u] + Math.max(0, up[u]);

        for (int v : adj[u]) {
            if (v == p) continue;
            // total outside v-subtree that can connect to v:
            int withoutV = dp[u] - Math.max(0, dp[v]); // dp[u] excluding contribution from v
            up[v] = Math.max(0, up[u] + withoutV);
            dfs2(v, u);
        }
    }
}
