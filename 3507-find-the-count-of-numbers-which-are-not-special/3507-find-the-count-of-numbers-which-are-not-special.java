class Solution{
    public int nonSpecialCount(int l, int r){
        int limit = (int)Math.sqrt(r);
        int n = r-l+1;
        boolean[] prime = new boolean[limit+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i=2; i*i<=limit; i++){
            if(prime[i]){
                for(int j=i*i; j<=limit; j+=i){
                    prime[j] = false;
                }                
            }
        } 

        int c = 0;
        for(int i=0; i<=limit; i++){
            if(prime[i] && i*i<=r && i*i>=l){
                c++;
            }
        }

        return r-l+1 - c;
    }
}