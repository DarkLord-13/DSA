class Solution {
    class Pair {
        int node;
        long time;
        public Pair(int node, long time) {
            this.node = node;
            this.time = time;
        }
    }

    int mod = (int)(1e9 + 7);
    
    public int countPaths(int n, int[][] roads) {
        long[] sd = new long[n];  // Changed to long
        int[] nw = new int[n];
        Arrays.fill(sd, Long.MAX_VALUE);
        sd[0] = 0;
        nw[0] = 1;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] a : roads) {
            adj.get(a[0]).add(new Pair(a[1], a[2]));
            adj.get(a[1]).add(new Pair(a[0], a[2]));
        } 

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        q.add(new Pair(0, 0));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int cn = p.node;
            long ct = p.time;   

            if(ct > sd[cn]) {
                continue;
            }       

            for(Pair next : adj.get(cn)) {
                int nn = next.node;
                long nt = next.time;
                long newTime = ct + nt;

                if(newTime < sd[nn]) {
                    sd[nn] = newTime;
                    nw[nn] = nw[cn] % mod;
                    q.add(new Pair(nn, newTime));
                }
                else if(newTime == sd[nn]) {
                    nw[nn] = (nw[nn] + nw[cn]) % mod;
                }
            }
        } 

        return nw[n-1] % mod;
    }
}