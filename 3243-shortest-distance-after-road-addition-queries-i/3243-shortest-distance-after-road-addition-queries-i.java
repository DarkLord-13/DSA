class Solution{
    public int[] shortestDistanceAfterQueries(int n, int[][] q){
        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<n; i++) ll.add(new ArrayList<>());

        for(int i=0; i<n-1; i++) ll.get(i).add(i + 1);

        int ql = q.length;
        int[] ans = new int[ql];
        for(int i=0; i<ql; i++){
            ll.get(q[i][0]).add(q[i][1]);
            ans[i] = f(ll);
        }

        return ans;
    }

    private int f(List<List<Integer>> ll){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        int n = ll.size(), d = 0;

        q.add(0);

        while(!q.isEmpty()){
            int s = q.size();

            for(int i=0; i<s; i++){
                int p = q.poll();

                if(p == n - 1) return d;

                for(int next: ll.get(p)){
                    if(!seen.contains(next)){
                        q.add(next);
                        seen.add(next);
                    }
                }
            }

            d++;
        }

        return -1;
    }
}