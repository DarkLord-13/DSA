class Solution{
    public int[][] highestPeak(int[][] g){
        Queue<int[]> q = new LinkedList<>();
        int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};

        int m = g.length, n = g[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 1){
                    g[i][j] = 0;
                    q.add(new int[] {i, j});
                }
                else{
                    g[i][j] = 1;
                }
            }
        }

        int[][] v = new int[m][n];

        while(!q.isEmpty()){
            int s = q.size();

            for(int z=0; z<s; z++){
                int[] poll = q.poll();
                int i = poll[0], j = poll[1];

                for(int p=0; p<4; p++){
                    int ni = i + x[p], nj = j + y[p];

                    if(isSafe(ni, nj, g, v, m, n)){
                        g[ni][nj] = g[i][j] + 1;
                        q.add(new int[] {ni, nj});
                        v[ni][nj] = 1;
                    }
                }
            }
        }

        return g;
    }

    private boolean isSafe(int i, int j, int[][] g, int[][] v, int m, int n){
        if(i >= m || j >= n || i < 0 || j < 0 || g[i][j] == 0 || v[i][j] == 1)
            return false;
        else 
            return true;
    }
}