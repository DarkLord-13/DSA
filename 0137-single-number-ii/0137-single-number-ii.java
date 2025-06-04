class Solution{
    public int singleNumber(int[] a){
        int n = a.length;
        int ones = 0, twos = 0;

        for(int num: a){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}