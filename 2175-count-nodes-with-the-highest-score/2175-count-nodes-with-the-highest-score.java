class Solution{
    int[] p, s;
    List<List<Integer>> adj = new ArrayList<>();
    public int countHighestScoreNodes(int[] px){        
        p = px;
        int n = p.length;

        if(n == 2 && p[0] == -1 && p[1] == 0) return 2;        
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int child=0; child<n; child++){
            int parent = p[child];

            if(parent != -1){
                adj.get(parent).add(child);
            }            
        }

        s = new int[n];
        Arrays.fill(s, 0);
        dfs(0);

        long max = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            long total = s[0], left = 0, right = 0;

            if(adj.get(i).size() == 2){
                left = s[adj.get(i).get(0)];
                right = s[adj.get(i).get(1)];
            }
            else if(adj.get(i).size() == 1){
                left = s[adj.get(i).get(0)];
            }

            long remaining = total - 1L - left - right;

            long a = (remaining > 0 ? remaining : 1);
            long b = (left   > 0 ? left   : 1);
            long c = (right  > 0 ? right  : 1);

            long score = a * b * c;
            max = Math.max(max, score);
            map.put(score, map.getOrDefault(score, 0) + 1);
        } 

        return map.get(max);
    }
    private int dfs(int u){
        s[u] = 1;
        for(int next: adj.get(u)){
            s[u] += dfs(next);
        }

        return s[u];
    }
}