class Solution{
    class Pair{
        int node, t;

        public Pair(int node, int t){
            this.node = node;
            this.t = t;
        }
        @Override 
        public String toString(){
            return node + "-" + t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src){
        int[] sd = new int[n+1];
        Arrays.fill(sd, Integer.MAX_VALUE);
        sd[src] = 0;
        sd[0] = 0;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n+1; i++){
            adj.add(new ArrayList<>());
        } 

        for(int[] a: times){
            int from = a[0];
            int to = a[1];
            int delay = a[2];

            adj.get(from).add(new Pair(to, delay));
        } //System.out.println(adj);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int cn = p.node;
            int ct = p.t;

            for(Pair next: adj.get(cn)){
                int nn = next.node;
                int nt = next.t;

                if(ct+nt<sd[nn]){
                    sd[nn] = ct+nt;
                    q.add(new Pair(nn, sd[nn]));
                    // print(sd);
                }
            }
        }

        int max = 0;
        for(int i: sd){
            if(i==Integer.MAX_VALUE){
                return -1;
            }
            else{
                max = Math.max(max, i);
            }
        }

        return max;
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}