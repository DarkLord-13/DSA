//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    int m, V;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    boolean graphColoring(int Vx, List<int[]> e, int mx){
        m = mx; V = Vx;
        for(int i=0; i<V; i++) adj.add(new ArrayList<>());
        for(int[] a: e){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        } //System.out.println(adj); return true;
        
        int[] color = new int[V];
        boolean x = dfs(0, color);
        
        /*for(int i=0; i<V; i++){
            for(int node: adj.get(i)){
                if(color[i]==color[node]) return false;
            }
        }*/
        
        return x;
    }
    boolean dfs(int node, int[] color){
        if(node==V) return true;
        
        for(int num=1; num<=m; num++){
            if(isSafe(node, num, color)){
                color[node] = num;
                
                if(dfs(node+1, color)==true) return true;
                
                color[node] = 0;
            }
        }
        
        return false;
    }
    boolean isSafe(int node, int num, int[] color){
        for(int i: adj.get(node)){
            //System.out.println(i);
            if(color[i]==num) return false;
        }
        
        return true;
    }
}