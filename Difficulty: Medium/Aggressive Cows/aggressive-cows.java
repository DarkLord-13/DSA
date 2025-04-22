//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    public static int aggressiveCows(int[] s, int k){
        int n = s.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        Arrays.sort(s);
        
        for(int i=0; i<n-1; i++){
            min = Math.min(min, s[i+1]-s[i]);
        }
        max = s[n-1] - s[0];
        // System.out.println(min);
        // System.out.println(max);
        
        int l = min;
        int h = max;
        int ans = 1;
        
        while(l <= h){
            int minDist = (l+h) >> 1;
            boolean isPossible = possible(minDist, s, n, k);
            //System.out.println(minDist + " " + isPossible);
            
            if(isPossible){
                ans = minDist;
                l = minDist+1;
            }
            else{
                h = minDist-1;
            }
        }
        
        return ans;
    }
    static boolean possible(int minDist, int[] s, int n, int k){
        k--;
        int last = s[0];
        
        for(int i=1; i<n; i++){
            if(s[i]-last >= minDist){
                k--;
                last = s[i];
            }
        }
        
        if(k <= 0){
            return true;
        }
        else{
            return false;
        }
    }
}