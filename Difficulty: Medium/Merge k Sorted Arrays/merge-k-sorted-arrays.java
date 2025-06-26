class Solution{
    class Pair{
        int num, li, ei;
        
        public Pair(int num, int li, int ei){
            this.num = num;
            this.li = li;
            this.ei = ei;
        }
    }
    public ArrayList<Integer> mergeKArrays(int[][] g, int k){
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> a.num - b.num);
        ArrayList<Integer> l = new ArrayList<>();
        int m = g.length, n = g[0].length;
        
        for(int i=0; i<m; i++){
            q.add(new Pair(g[i][0], i, 0));
        }
        
        while(!q.isEmpty()){
            Pair poll = q.poll();
            l.add(poll.num);
            int li = poll.li, ei = poll.ei;
            
            if(ei < n-1){
                q.add(new Pair(g[li][ei + 1], li, ei + 1));
            }
        }
        
        return l;
    }
}