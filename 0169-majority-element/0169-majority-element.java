class Solution{
    public int majorityElement(int[] a){
        int num = a[0], f = 1, n = a.length;
        for(int i=1; i<n; i++){
            if(a[i]==num) f++;
            else f--;
            if(f==0){
                num = a[i];
                f = 1;
            }
        }        

        return num;
    }
}