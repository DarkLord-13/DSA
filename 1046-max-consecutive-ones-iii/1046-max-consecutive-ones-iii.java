class Solution{
    public int longestOnes(int[] a, int k){
        int i=0, j=0, l=a.length, c=0, max=0;
        
        while(j<l){
            if(a[j]==0){                
                if(c<k){
                    c++;
                }
                else{
                    while(a[i]!=0) i++;
                    i++;
                }                               
            }
            j++;
            max = Math.max(j-i, max);
        }
        
        return max;
    }
}