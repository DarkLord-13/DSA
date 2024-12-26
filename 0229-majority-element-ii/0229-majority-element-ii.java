class Solution{
    public List<Integer> majorityElement(int[] a){
        int n = a.length;
        int maj1 = 0, maj2 = 0;
        int f1 = 0, f2 = 0;
        
        for(int i=0; i<n; i++){
            if(maj1==a[i]) f1++;
            else if(maj2==a[i]) f2++;
            else if(f1==0){
                maj1 = a[i];
                f1 = 1;
            }
            else if(f2==0){
                maj2 = a[i];
                f2 = 1;
            }
            else{
                f1--;         
                f2--;
            }            
        }

        f1 = 0; f2 = 0;
        for(int i=0; i<n; i++){
            if(a[i]==maj1) f1++;
            else if(a[i]==maj2) f2++;
        }

        ArrayList<Integer> l = new ArrayList<>(2);
        if(f1>(n/3)) l.add(maj1);
        if(f2>(n/3)) l.add(maj2);
        return l;
    }
}