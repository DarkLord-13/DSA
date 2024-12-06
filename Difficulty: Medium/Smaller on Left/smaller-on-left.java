//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        
System.out.println("~");
}
    }
}
// } Driver Code Ends

class Solution{
    static List<Integer> leftSmaller(int n, int a[]){
        Stack<Integer> s = new Stack<>();
        Integer[] ret = new Integer[n];
        for(int i=0; i<n; i++){
            int num = a[i%n];
            
            while(!s.isEmpty() && s.peek()>=num) s.pop();
            
                if(s.isEmpty()) ret[i%n]=-1;
                else ret[i%n]=s.peek();
            //}
            s.push(num);
        }
        
        
        return Arrays.asList(ret);
    }
}