//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends

class Solution{
    static int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        
        if(px==py){
            return;
        }
        
        if(rank[px]>rank[py]){
            parent[py] = px;
        }
        else if(rank[y]>rank[x]){
            parent[px] = py;
        }
        else{
            parent[py] = px;
            rank[px]++;
        }
    }
    
    static int[] parent, rank;
    static int spanningTree(int V, int E, List<List<int[]>> adj){
        parent = new int[V];
        rank = new int[V];
        
        for(int i=0; i<V; i++){
            parent[i] = i;
        }
        
        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b)-> a.get(0)-b.get(0));
        
        for(int i=0; i<V; i++){
            for(int[] edge: adj.get(i)){
                int from = i;
                int to = edge[0];
                int w = edge[1];
                
                List<Integer> l = new ArrayList<>();
                l.add(w);
                l.add(from);
                l.add(to);
                
                q.add(l);
            }
        }
        
        int sum = 0;
        while(!q.isEmpty()){
            List<Integer> l = q.poll();
            int w = l.get(0);
            int from = l.get(1);
            int to = l.get(2);
            
            if(find(from)!=find(to)){
                union(from, to);
                sum += w;
            }
        }
        
        return sum;
    }
}











