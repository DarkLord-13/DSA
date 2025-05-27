class Solution{
    public int findLatestStep(int[] a, int m){
        int n = a.length;
        if(m == n){
            return n;
        }

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(0);
        ts.add(n+1);
        

        for(int i=n-1; i>=0; i--){
            int curr = a[i];
            
            int left = ts.floor(curr);
            int right = ts.ceiling(curr);

            if(right-curr-1==m || curr-left-1==m){
                return i;
            }

            ts.add(curr);
        }        

        return -1;
    }
}