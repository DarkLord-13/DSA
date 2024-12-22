//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution{
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int bag){
        int n = val.size();
        double[][] arr = new double[n][3]; // arr[wt][val][val/wt]
        for(int i=0; i<n; i++){
            arr[i][0] = wt.get(i);
            arr[i][1] = val.get(i);
            arr[i][2] = ((double)val.get(i)/(double)wt.get(i));
        }
        /*for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
        }*/
        
        Arrays.sort(arr, (a, b)-> {
            return Double.compare(b[2], a[2]);
        });
        /*for(int i=0; i<n; i++){
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2]);
        }*/
        
        int i=0;
        double cc=0, cv=0;
        while(i<n && cc<=bag){
            if(cc+arr[i][0]<=bag){
                cc+=arr[i][0];
                cv+=arr[i][1];
            }
            else{
                double remSpace=bag-cc;
                double percentage = remSpace/arr[i][0];
                cc+=remSpace;
                cv+=(percentage*arr[i][1]);
            }
            i++;
        }
        
        return cv;
    }
}