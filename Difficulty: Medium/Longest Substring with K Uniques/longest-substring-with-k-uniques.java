//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    public int longestkSubstr(String s, int k){
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0, j=0, l=s.length(), max=0;
        char[] a = s.toCharArray();
        
        while(j<l){
            map.put(a[j], map.getOrDefault(a[j], 0)+1);
            
            if(map.size()>k){
                while(map.size()>k){
                    map.put(a[i], map.get(a[i])-1);
                    if(map.get(a[i])==0) map.remove(a[i]);
                    i++;
                }
            }
            j++;
            max = Math.max(j-i, max);
        }
        
        if(map.size()<k) return -1;
        return max;
    }
}