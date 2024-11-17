class Solution{
    public int[] countBits(int n){
        int[] a = new int[n+1];
        for(int num=0; num<=n; num++){
            int c = 0;
            int i = num;
            while(i>0){
                if(i%2==1) c+=1;
                i/=2;
            }
            a[num] = c;
        }

        return a;
    }
}