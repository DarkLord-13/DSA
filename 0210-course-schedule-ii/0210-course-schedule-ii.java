class Solution{
    List<List<Integer>> ll;
    public int[] findOrder(int nc, int[][] pre){
        if(pre.length == 0){
            int[] ret = new int[nc];
            for(int i=0; i<nc; i++){
                ret[i] = i;
            }

            return ret;
        }

        this.ll = new ArrayList<>();
        for(int i=0; i<nc; i++){
            ll.add(new ArrayList<>());
        }
        for(int[] a: pre){
            ll.get(a[1]).add(a[0]);
        }
        // System.out.println(ll);

        int[] v = new int[nc];

        for(int i=0; i<nc; i++){
            if(v[i] == 0){
                if(cycle(i, v)){
                    return new int[0];
                }
            }
        }
        

        Stack<Integer> s = new Stack<>();
        v = new int[nc];

        for(int i=0; i<nc; i++){
            if(v[i] == 0){
                dfs(i, s, v);
            }
        }        

        int size = s.size();
        int[] ret = new int[nc];
        
        for(int i=0; i<size; i++){
            ret[i] = s.pop();
        }

        return ret;
    }
    boolean cycle(int i, int[] v){
        if(v[i] == 1){
            return true;
        }

        v[i] = 1;
        for(int next: ll.get(i)){
            if(cycle(next, v)){
                return true;
            }
        }
        v[i] = 0;

        return false;
    }
    void dfs(int i, Stack<Integer> s, int[] v){
        if(v[i] == 1){
            return;
        }

        v[i] = 1;
        for(int next: ll.get(i)){
            dfs(next, s, v);
        }
        s.push(i);
    }
}