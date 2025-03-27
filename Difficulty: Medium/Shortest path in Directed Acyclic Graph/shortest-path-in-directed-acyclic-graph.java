//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    class Pair{
        int node, d;
        
        public Pair(int node, int d){
            this.node = node;
            this.d = d;
        }
    }
    public int[] shortestPath(int V, int E, int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge: edges){
            int from = edge[0];
            int to = edge[1];
            int w = edge[2];
            
            adj.get(from).add(new Pair(to, w));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> a.d-b.d);
        q.add(new Pair(0, 0));
        
        int[] dist = new int[V];
        Arrays.fill(dist, 99999);
        dist[0] = 0;
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            int cn = p.node;
            int cd = p.d;
            
            for(Pair next: adj.get(cn)){
                int nn = next.node;
                int nd = next.d;
                
                if(dist[cn]+nd<dist[nn]){
                    dist[nn] = dist[cn]+nd;
                    q.add(new Pair(nn, dist[nn]));
                }
            }
        }
        
        for(int i=0; i<V; i++){
            if(dist[i]==99999){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}