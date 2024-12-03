//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    int[] a; int target, n;
    Boolean isSubsetSum(int arr[], int tx){
        a = arr; target = tx; n = a.length;
        
        return f(0, 0);
    }
    boolean f(int i, int sum){
        if(sum==target) return true;
        if(i>=n || sum>target) return false;
        
        return f(i+1, sum+a[i])||f(i+1, sum);
    }
}