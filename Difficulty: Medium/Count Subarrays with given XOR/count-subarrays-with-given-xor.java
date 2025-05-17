//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    public long subarrayXor(int[] a, int k){
        long c = 0;
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int xor = 0;
        for(int i: a){
            xor ^= i;
            
            int px = xor^k;
            if(map.containsKey(px)){
                c += map.get(px);
            }
            
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        
        return c;
    }
}