//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.preToPost(s);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}

// } Driver Code Ends

class Solution{
    String preToPost(String e){
        int n = e.length();
        Stack<String> st = new Stack<>();
        HashSet<String> ops = new HashSet<>();
        ops.add("*"); ops.add("/"); ops.add("^"); 
        ops.add("+"); ops.add("-"); 
        
        for(int i=0; i<n; i++){
            String s = Character.toString(e.charAt(n-i-1));
            if(!ops.contains(s)) st.push(s);
            else{
                String a = st.pop(), b = st.pop();
                st.push(a+b+s);
            }
        }
        
        return st.pop();
    }
}
