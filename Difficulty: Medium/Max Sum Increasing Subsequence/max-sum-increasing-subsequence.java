//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution ob = new Solution();
            System.out.println(ob.maxSumIS(arr));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    Integer[][] memo;
    public int maxSumIS(int[] a){
        int n = a.length;
        memo = new Integer[n][n+1];
        
        return f(0, -1, a);
    }
    int f(int i, int maxi, int[] a){
        if(i >= a.length){
            return 0;
        }
        if(memo[i][maxi+1] != null){
            return memo[i][maxi+1];
        }
        
        int take = 0;
        if(maxi == -1 || a[i] > a[maxi]){
            take = a[i] + f(i+1, i, a);
        }
        
        int nonTake = f(i+1, maxi, a);
        
        return memo[i][maxi+1] = Math.max(take, nonTake);
    }
}