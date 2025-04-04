class Solution{
    int[] parent;
    public int makeConnected(int n, int[][] conn){
        if(conn.length<n-1){
            return -1;
        }

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        
        int c = n;
        for(int[] edge: conn){
            int a = find(edge[0]);
            int b = find(edge[1]);

            if(a!=b){
                parent[a] = b;
                c--;
            }
        }

        return c-1;
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}