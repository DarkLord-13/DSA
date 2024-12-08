//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    public int celebrity(int g[][]){
        int n = g.length;
        
        for(int j=0; j<n; j++){
            int sum = 0;
            for(int i=0; i<n; i++){
                if(i!=j) sum+=g[i][j];
            }
            
            if(sum==n-1){
                int knowSum = arraySum(g[j]);
                if(knowSum==0) return j;
            }
        }
        
        return -1;
    }
    int arraySum(int[] arr){
        int sum = 0;
        for(int i: arr) sum+=i;
        return sum;
    }
}