class Solution{
    public int maximalRectangle(char[][] g){
        int rows = g.length, cols = g[0].length;
        int[][] ng = new int[rows][cols];
        for(int c=0; c<cols; c++){
            int sum = 0;
            for(int r=0; r<rows; r++){
                if(g[r][c]=='1'){
                    sum+=1;
                }
                else{
                    sum = 0;
                }
                ng[r][c] = sum;
            }
        }
        
        int maxi = 0;
        for(int[] a: ng){
            maxi = Math.max(maxi, area(a));
        }

        return maxi;
    }
    int area(int[] a){
        int n = a.length, maxi = 0;
        int[] pse = preMin(a), nse = sufMin(a);

        for(int i=0; i<n; i++){
            int cs = ((i-pse[i])+(nse[i]-i-1))*a[i];
            maxi = Math.max(cs, maxi);
        }

        return maxi;
    }
    int[] preMin(int[] a){
        int n = a.length; int[] ret = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]) s.pop();
            int p = s.isEmpty() ? -1 : s.peek();
            ret[i] = p;
            s.push(i);
        }

        return ret;
    }
    int[] sufMin(int[] a){
        int n = a.length; int[] ret = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]>a[i]) s.pop();
            int p = s.isEmpty() ? n : s.peek();
            ret[i] = p;
            s.push(i);
        }

        return ret;
    }
}