class Solution{
    public List<Integer> findCoins(int[] numWays){
        int n = numWays.length;
        int[] myWays = new int[n+1];
        myWays[0] = 1;

        List<Integer> res = new ArrayList<>();

        for(int amount=1; amount<=n; amount++){
            if(myWays[amount] == numWays[amount-1]){
                continue;
            }
            else if(myWays[amount] + 1 == numWays[amount-1]){
                res.add(amount); // coin == amount

                for(int nextAmount=amount; nextAmount<=n; nextAmount++){
                    myWays[nextAmount] += myWays[nextAmount - amount];
                }
            }
            else{
                return Collections.emptyList();
            }
        }    

        return res;
    }
}