//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class Solution{
    int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};
    char[] d = {'U', 'R', 'D', 'L'};
    ArrayList<String> l = new ArrayList<>(); int n;
    ArrayList<ArrayList<Integer>> mat;
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> matx){
        mat = matx; n = mat.size(); 
        
        boolean x = f(0, 0, new int[n][n], new StringBuilder());
        Collections.sort(l);
        
        return l;
    }
    boolean f(int i, int j, int[][] v, StringBuilder sb){
        //System.out.println(sb);
        if(i==n-1&&j==n-1){
            //l.add(sb.toString());
            return true;
        }
        v[i][j] = 1;
        
        for(int p=0; p<4; p++){
            int ni = i+x[p], nj = j+y[p];
            if(isSafe(ni, nj, v)){
                sb.append(d[p]);
                if(f(ni, nj, v, sb)) l.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
            }
        }
        v[i][j] = 0;
        
        return false;
        
    }
    boolean isSafe(int i, int j, int[][] v){
        if(i>=n||j>=n||i<0||j<0||v[i][j]==1||mat.get(i).get(j)==0) 
            return false; 
        return true;
    }
}