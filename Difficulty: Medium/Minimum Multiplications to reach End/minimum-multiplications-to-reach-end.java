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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    int minimumMultiplications(int[] arr, int start, int end){
        int mod = (int)(Math.pow(10, 5));
        int n = arr.length;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start%mod);
        
        int steps = 0;
        
        int[] v = new int[100009];
        v[start%mod] = 1;
        
        while(!q.isEmpty()){

            int s = q.size();
            for(int i=0; i<s; i++){
                int curr = q.poll();
                if(curr==end){
                    return steps;
                }
                
                for(int num: arr){
                    int next = ((curr%mod) * (num%mod))%mod;
                    
                    if(v[next]==0){
                        v[next] = 1;
                        q.add(next);
                    }
                }
            }
            
            steps++;
        }
        
        return -1;
    }
}
