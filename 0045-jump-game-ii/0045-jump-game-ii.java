class Solution{
    public int jump(int[] jumps){
        int l=0, r=0, n=jumps.length, steps=0;

        while(r<n-1){
            int farthest=0;

            for(int i=l; i<=r; i++){
                farthest = Math.max(farthest, i+jumps[i]);
            }

            l=r+1;
            r=farthest;
            steps++;
        }

        return steps;        
    }
}