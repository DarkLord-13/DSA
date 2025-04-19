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
    int spanningTree(int V, int E, List<List<int[]>> adj){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{
            return a[1] - b[1];
        });
        q.add(new int[]{0, 0});
        
        int sum = 0;
        int[] v = new int[V];

        while(!q.isEmpty()){
            int[] edge = q.poll();
            int to = edge[0];
            int w = edge[1];
            
            if(v[to]==1){
                continue;
            }
            
            v[to] = 1;
            sum += w;
            for(int[] nextEdge: adj.get(to)){
                q.add(nextEdge);
            }
        }
        
        return sum;
    }
}
