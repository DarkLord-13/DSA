public class Solution{
    public int reverseBits(int n){
        int r = 0;
        for(int i=0; i<32; i++){
            // Extract the last bit of n
            int b = n&1;
            // Shift result left to make space for the new bit
            r = (r<<1) | b;
            // Shift n right to process the next LSB of n
            n >>= 1;
        }
        return r;
    }
}
