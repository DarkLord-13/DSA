class Solution{

    private int[] x = {-1, -1, 0, +1, +1, +1, 0, -1};
    private int[] y = {0, +1, +1, +1, 0, -1, -1, -1};

    public int shortestPathBinaryMatrix(int[][] g){
        if(g[0][0] == 1 || g[g.length - 1][g[0].length - 1] == 1){
            return -1;
        }

        int n = g.length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 1});

        int[][] v = new int[n][n];
        v[0][0] = 1;

        while(!q.isEmpty()){
            int s = q.size();

            for(int z=0; z<s; z++){
                int[] poll = q.poll();

                int i = poll[0], j = poll[1], d = poll[2];

                if(i == n - 1 && j == n - 1) return d;

                for(int p=0; p<8; p++){
                    int ni = i + x[p], nj = j + y[p];

                    if(isSafe(ni, nj, g, v)){
                        v[ni][nj] = 1;
                        q.add(new int[] {ni, nj, d + 1});
                    }
                }
            }            
        }

        return -1;
    }

    private boolean isSafe(int i, int j, int[][] g, int[][] v){
        int n = g.length;

        return !(i < 0 || j < 0 || i >= n || j >= n || g[i][j] == 1 || v[i][j] == 1);
    }
}