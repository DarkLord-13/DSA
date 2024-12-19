//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    class Pair{
        int s, e;
        public Pair(int s, int e){
            this.s=s; this.e=e;
        }
    }
    public int maxMeetings(int start[], int end[]){
        int n = start.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> {
            return a.e-b.e;
        });
        
        for(int i=0; i<n; i++) q.add(new Pair(start[i], end[i]));
        
        Pair p = q.poll();
        int s = p.s, e = p.e;
        int jobs = 1;
        
        while(!q.isEmpty()){
            p = q.poll();
            if(p.s>e){
                jobs++;
                e = p.e;
            }
        }
        
        return jobs;
    }
}
