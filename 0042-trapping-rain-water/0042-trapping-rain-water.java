class Solution{
    public int trap(int[] h){
        int n = h.length;
        int[] pge = new int[n];
        int[] nge = new int[n];
        
        pge[0] = h[0];
        for(int i=1; i<n; i++){
            pge[i] = Math.max(pge[i-1], h[i]);
        }

        nge[n-1] = h[n-1];
        for(int i=n-2; i>=0; i--){
            nge[i] = Math.max(nge[i+1], h[i]);
        }

        int sum = 0;
        for(int i=1; i<n-1; i++){
            sum += Math.abs(Math.min(pge[i], nge[i]) - h[i]);
        }

        return sum;
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }
}