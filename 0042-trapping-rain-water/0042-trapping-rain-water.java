class Solution{
    public int trap(int[] h){
        int n = h.length;

        // calculating maxPrefix
        int[] pre = new int[n]; pre[0] = h[0];
        for(int i=1; i<n; i++) pre[i] = Math.max(h[i], pre[i-1]); //print(pre);

        // calculating maxSuffix
        int[] suf = new int[n]; suf[n-1] = h[n-1];
        for(int i=n-2; i>=0; i--) suf[i] = Math.max(h[i], suf[i+1]); //print(suf);

        int total = 0;
        for(int i=0; i<n; i++){
            if(h[i]<pre[i] && h[i]<suf[i]){
                total += Math.min(pre[i], suf[i]) - h[i];
            }
        }

        return total;
    }
    void print(int[] arr){
        for(int i: arr) System.out.print(i + " ");
        System.out.println();
    }
}