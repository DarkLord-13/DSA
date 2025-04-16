//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends

class Solution{
    List<List<Integer>> adj = new ArrayList<>();
    public ArrayList<Integer> topoSort(int V, int[][] edges){
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
        } //System.out.println(adj);
        
        ArrayList<Integer> l = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] v = new int[V];
        
        for(int i=0; i<V; i++){
            if(v[i]==0){
                dfs(i, v, st);
            }
        }
        
        while(!st.isEmpty()){
            l.add(st.pop());
        } //System.out.println(l);
        
        return l;
        
    }
    void dfs(int i, int[] v, Stack<Integer> st){
        // if(v[i]==1){
        //     return;
        // }
        v[i] = 1;
        
        for(int next: adj.get(i)){
            if(v[next]==0){
                dfs(next, v, st);
            }
        }
        
        st.push(i);
    }
}