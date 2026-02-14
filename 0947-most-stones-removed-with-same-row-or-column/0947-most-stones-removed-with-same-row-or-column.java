class Solution{

    private class DSU{
        int[] p;

        public DSU(int n){
            this.p = new int[n];
            for(int i=0; i<n; i++) p[i] = i;
        }

        int find(int x){
            if(p[x] != x){
                return p[x] = find(p[x]);
            }

            return p[x];
        }

        boolean union(int x, int y){
            x = find(x);
            y = find(y);

            if(x != y){
                p[x] = y;
                return true;
            }
            else return false;
        }
    }

    public int removeStones(int[][] stones){
        int maxR = 0, maxC = 0;
        for(int[] s: stones){
            int x = s[0], y = s[1];
            maxR = Math.max(maxR, x);
            maxC = Math.max(maxC, y);
        }

        DSU dsu = new DSU(maxR + maxC + 2);
        for(int[] s: stones){
            int x = s[0], y = s[1];
            y += maxR + 1;

            dsu.union(x, y);
        }

        int[] parent = dsu.p;
        for(int i=0; i<parent.length; i++) parent[i] = dsu.find(i);

        Set<Integer> nodes = new HashSet<>();
        for(int[] s: stones){
            int x = s[0], y = s[1];
            y += maxR + 1;

            nodes.add(dsu.find(x));
            nodes.add(dsu.find(y));
        }

        Set<Integer> set = new HashSet<>();
        for(int p: parent){
            if(nodes.contains(p)) set.add(p);
        }

        return stones.length - set.size();
    }
}