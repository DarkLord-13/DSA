//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class GfG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] jobIDStrings = sc.nextLine().split(" ");
            String[] deadlineStrings = sc.nextLine().split(" ");
            String[] profitStrings = sc.nextLine().split(" ");

            // Convert the input strings to integer arrays
            int[] jobIDs = new int[jobIDStrings.length];
            int[] deadlines = new int[deadlineStrings.length];
            int[] profits = new int[profitStrings.length];

            for (int i = 0; i < jobIDStrings.length; i++) {
                jobIDs[i] = Integer.parseInt(jobIDStrings[i]);
                deadlines[i] = Integer.parseInt(deadlineStrings[i]);
                profits[i] = Integer.parseInt(profitStrings[i]);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.JobSequencing(jobIDs, deadlines, profits);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution{
    class Pair{
        int d, p;
        public Pair(int d, int p){
            this.d=d; this.p=p;
        }
    }
    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit){
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)->{
            return -(a.p-b.p);
        });
        
        int n=id.length;
        for(int i=0; i<n; i++){
            q.add(new Pair(deadline[i], profit[i]));
        }
        
        int job = 0, totalProfit = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()){
            Pair poll = q.poll();
            int cd = poll.d, cp = poll.p;

            int i = cd;
            while(i>0){
                if(!set.contains(i)){
                    job++;
                    totalProfit+=cp;
                    set.add(i);
                    break;
                }
                else i--;
            }
        }
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add(job); a.add(totalProfit);
        return a;
    }
}
