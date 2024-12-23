class Solution{
    public int[][] merge(int[][] a){
        int n = a.length;
        if(n<2) return a;

        Arrays.sort(a, (x, y)->{
            return x[0]-y[0];
        });

        ArrayList<Integer> li = new ArrayList<>();
        ArrayList<Integer> lj = new ArrayList<>();
        int i = 1, start = a[0][0], end = a[0][1], max = end;

        while(i<n){
            
            while(i<n && end>=a[i][0]){
                max = Math.max(max, a[i][1]);
                end = max;
                i++;                
            }

            li.add(start);
            lj.add(max);

            if(i<n){
                start = a[i][0];
                end = a[i][1];
            }
        }

        int s = li.size();
        int[][] ret = new int[s][2];
        for(i=0; i<s; i++){
            ret[i][0] = li.get(i);
            ret[i][1] = lj.get(i);
        }

        return ret;
    }
}