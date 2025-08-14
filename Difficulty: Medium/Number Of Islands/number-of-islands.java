import java.util.*;

public class Solution {
    private int[] parent;
    private int[] rank;
    private int rows, cols;
    private int islandCount;

    // 4-direction neighbors (up, right, down, left)
    private final int[] dr = {-1, 0, 1, 0};
    private final int[] dc = {0, 1, 0, -1};

    private int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    // returns true if a union merged two different sets
    private boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx == ry) return false;

        if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
        return true;
    }

    /**
     * m = number of rows, n = number of columns, qq = list of operators {r,c} to turn sea->land
     */
    public List<Integer> numOfIslands(int m, int n, int[][] qq) {
        rows = m;
        cols = n;
        int total = rows * cols;
        parent = new int[total];
        rank = new int[total];
        // -1 means water
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 0);

        List<Integer> res = new ArrayList<>();
        islandCount = 0;

        for (int[] op : qq) {
            int r = op[0], c = op[1];
            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                // invalid op; you can choose to skip or throw. Here we'll skip and append current count.
                res.add(islandCount);
                continue;
            }

            int idx = r * cols + c;

            // if already land (duplicate operation), result doesn't change
            if (parent[idx] != -1) {
                res.add(islandCount);
                continue;
            }

            // make this cell a new island
            parent[idx] = idx;
            rank[idx] = 0;
            islandCount++;

            // try union with 4 neighbors
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                int nidx = nr * cols + nc;
                if (parent[nidx] != -1) { // neighbor is land
                    if (union(idx, nidx)) {
                        // successfully merged two islands
                        islandCount--;
                    }
                }
            }

            res.add(islandCount);
        }

        return res;
    }
}
