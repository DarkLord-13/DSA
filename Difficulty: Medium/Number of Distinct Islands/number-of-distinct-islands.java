//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    int m, n;
    int[][] g, v;
    int[] x = {-1, 0, +1, 0};
    int[] y = {0, +1, 0, -1};
    char[] dir = {'U', 'R', 'D', 'L'};
    Set<String> set = new HashSet<>();
    int countDistinctIslands(int[][] gx){
        g = gx;
        m = g.length;
        n = g[0].length;
        v = new int[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j]==1 && v[i][j]==0){
                    StringBuilder sb = new StringBuilder();
                    dfs(i, j, sb, 'O');
                    set.add(sb.toString());
                }
            }
        }
        
        return set.size();
    }
    void dfs(int i, int j, StringBuilder sb, char move){
        if(i<0 || j<0 || i>=m || j>=n || g[i][j]==0 || v[i][j]==1){
            return;
        }
        v[i][j] = 1;
        sb.append(move);
        
        for(int p=0; p<4; p++){
            int ni = i+x[p];
            int nj = j+y[p];
            char ndir = dir[p];
            
            dfs(ni, nj, sb, ndir);
        }
        
        sb.append('B');
    }
}
