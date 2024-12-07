class Solution {
    public int largestRectangleArea(int[] a){
        int n = a.length, maxi = 0;
        int[] pse = preMin(a); 
        int[] nse = sufMin(a);

        for(int i=0; i<n; i++){
            int cm = ((i-pse[i])+(nse[i]-i-1))*a[i];
            maxi = Math.max(cm, maxi);
        }

        return maxi;
    }
    int[] preMin(int[] a){
        int n = a.length;
        int[] ret = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<n; i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]) s.pop();
            int ind = s.isEmpty() ? -1 : s.peek();
            ret[i] = ind;
            s.push(i);
        }

        return ret;
    }
    int[] sufMin(int[] a){
        int n = a.length;
        int[] ret = new int[n];
        Stack<Integer> s = new Stack<>();

        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]>a[i]) s.pop();
            int ind = s.isEmpty() ? n : s.peek();
            ret[i] = ind;
            s.push(i);
        }

        return ret;
    }
}