//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    ArrayList<ArrayList<Integer>> adj;
    int[] v;
    Boolean[] memo;
    public boolean isCyclic(ArrayList<ArrayList<Integer>> adjx){
        adj = adjx;
        int n = adj.size();
        v = new int[n];
        memo = new Boolean[n];

        for(int i=0; i<n; i++){
            if(!dfs(i)){
                return true;
            }
        }
        
        return false;
    }
    boolean dfs(int i){
        if(v[i]==1){
            return false;
        }
        if(memo[i]!=null){
            return memo[i];
        }
        
        v[i] = 1;
        boolean ret = true;
        for(int next: adj.get(i)){
            ret = ret & dfs(next);
        }
        v[i] = 0;
        
        return memo[i]=ret;
    }
}
/*
4 4
0 1
1 2
2 3
3 3

5 3
3 0
4 2
1 2
*/