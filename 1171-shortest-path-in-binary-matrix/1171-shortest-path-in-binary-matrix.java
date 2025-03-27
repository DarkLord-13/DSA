class Solution{
    class Pair{
        int i, j, d;

        public Pair(int i, int j, int d){
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }
    int n;
    int[][] g;
    int[] x = {-1,-1,0,+1,+1,+1,0,-1};
    int[] y = {0,+1,+1,+1,0,-1,-1,-1};
    int[][] v;
    public int shortestPathBinaryMatrix(int[][] gx){
        g = gx;
        n = g.length;
        v = new int[n][n];

        if(g[0][0]==1){
            return -1;
        }
        if(n==1){
            if(g[0][0]==0){
                return 1;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 1));

        int dist = 99999;
        while(!q.isEmpty()){
            Pair poll = q.poll();
            int i = poll.i;
            int j = poll.j;
            int d = poll.d;

            for(int p=0; p<8; p++){
                int ni = i+x[p];
                int nj = j+y[p];
                if(safe(ni, nj)){
                    if(ni==n-1 && nj==n-1){
                        dist = Math.min(dist, d);
                    }
                    else{
                        q.add(new Pair(ni, nj, d+1));
                    }
                }
            }
        }

        if(dist==99999){
            return -1;
        }
        return dist+1;
    }
    boolean safe(int i, int j){
        if(i>=n || j>=n || i<0 || j<0 || g[i][j]==1 || v[i][j]==1){
            return false;
        }
        else{
            v[i][j] = 1;
            return true;
        }
    }
    int dfs(int i, int j){
        if(i==n-1 && j==n-1 && g[i][j]==0){
            return 0;
        }
        if(i>=n || j>=n || i<0 || j<0 || g[i][j]==1 || v[i][j]==1){
            return 99999;
        }
        v[i][j] = 1;

        int dist = Integer.MAX_VALUE;
        for(int p=0; p<8; p++){
            int ni = i+x[p];
            int nj = j+y[p];

            dist = Math.min(dist, 1 + dfs(ni, nj));
        }
        v[i][j] = 0;

        return dist;
    }
}