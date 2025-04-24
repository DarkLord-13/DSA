//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    int median(int g[][]){
        int m = g.length;
        int n = g[0].length;
        int left = (m*n)/2;
        
        int l = Integer.MAX_VALUE;
        int h = Integer.MIN_VALUE;
        int mid = 0;
        
        for(int i=0; i<m; i++){
            l = Math.min(l, g[i][0]);
            h = Math.max(h, g[i][n-1]);
        }
        
        while(l <= h){
            mid = (l+h) >> 1;
            
            int lse = 0;
            for(int i=0; i<m; i++){
                lse += lessThanMid(g[i], mid);
            }

            if(lse <= left){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        
        return l - 1;
    }
    int lessThanMid(int[] arr, int mid){
        
        int count = 0;
        for(int i: arr){
            if(i < mid){
                count++;
            }
        }
        
        return count;
    }
}