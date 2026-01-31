class Solution{
    public int numRescueBoats(int[] w, int limit){
        Arrays.sort(w);
        int l = 0, r = w.length - 1, boats = 0;

        while(l <= r){
            if(w[l] + w[r] <= limit){
                l++;
                r--;
            }
            else{
                r--;
            }

            boats++;
        }

        return boats;
    }
}