class Solution{
    public int minTaps(int n, int[] r){
        int rl = r.length;
        int[] maxReach = new int[n+1];

        for(int i=0; i<rl; i++){
            int l = Math.max(0, i-r[i]);
            int rr = Math.min(n, i+r[i]);

            maxReach[l] = Math.max(maxReach[l], rr);
        } // print(maxReach);

        int taps = 0;
        int currEnd = 0;
        int farthest = 0;

        for(int i=0; i<n+1; i++){
            if(i > farthest){
                return -1;
            }           

            farthest = Math.max(farthest, maxReach[i]);

            if(i >= currEnd){
                taps++;
                currEnd = farthest;

                if(currEnd >= n){
                    break;
                }                
            }
        }

        if(currEnd >= n){
            return taps;
        }
        else{
            return -1;
        }
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }

        System.out.println();
    }
}
