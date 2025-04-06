class Solution{
    int[] parent;
    void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[x] = y;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    public int removeStones(int[][] stones){
        int mr = 0;
        int mc = 0;
        Set<Integer> ur = new HashSet<>();
        Set<Integer> uc = new HashSet<>();
        for(int[] stone: stones){
            int r = stone[0];
            int c = stone[1];

            ur.add(r);
            uc.add(c);

            mr = Math.max(mr, r);
            mc = Math.max(mc, c);
        }

        parent = new int[mr + mc + 2];
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }

        for(int[] stone: stones){
            int r = stone[0];
            int c = stone[1];

            union(r, mr + c + 1);
        }

        
        //print(parent);
        for(int i=0; i<parent.length; i++){
            parent[i] = find(parent[i]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i: parent){
            set.add(i);
        }
        //print(parent);

        return stones.length - set.size() + parent.length - (ur.size() + uc.size());
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}