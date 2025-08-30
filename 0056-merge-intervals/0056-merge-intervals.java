class Solution{
    public int[][] merge(int[][] g){
        int n = g.length;
        Arrays.sort(g, (a, b)-> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{
                return a[1] - b[1];
            }
        });

        int i = 1, s = g[0][0], e = g[0][1];
        List<List<Integer>> ll = new ArrayList<>();

        while(i < n){
            if(g[i][0] > e){
                ll.add(Arrays.asList(s, e));
                s = g[i][0];
                e = g[i][1];
            }
            else{
                e = Math.max(e, g[i][1]);
            }

            i++;
        }   
        ll.add(Arrays.asList(s, e));

        return listToArray(ll);     
    }

    private int[][] listToArray(List<List<Integer>> ll){
        int n = ll.size();
        int[][] ret = new int[n][2];

        for(int i=0; i<n; i++){
            ret[i][0] = ll.get(i).get(0);
            ret[i][1] = ll.get(i).get(1);
        }

        return ret;
    }
}