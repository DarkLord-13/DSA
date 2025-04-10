//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortestDistance(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    public void shortestDistance(int[][] g){
        int n = g.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j]==-1){
                    g[i][j] = 99999;
                }
            }
        }
        
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i!=j){
                        if(g[i][k] + g[k][j] < g[i][j]){
                            g[i][j] = g[i][k] + g[k][j];
                        }
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(g[i][j]==99999){
                    g[i][j] = -1;
                }
            }
        }
    }
}