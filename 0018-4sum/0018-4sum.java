class Solution{
    public List<List<Integer>> fourSum(int[] a, int t){        
        Arrays.sort(a);
        int len = a.length;

        List<List<Integer>> ll = new ArrayList<>();
        if(t<Integer.MIN_VALUE || t>Integer.MAX_VALUE) return ll;
        if(len<4) return ll;

        for(int i=0; i<len-3; i++){
            if(i>0 && a[i]==a[i-1]) continue;

            for(int j=i+1; j<len-2; j++){
                if(j>i+1 && a[j]==a[j-1]) continue;

                int l=j+1, r=len-1;
                while(l<r){
                    long sum = (long)a[i]+a[j]+a[l]+a[r];
                    if(sum<t) l++;
                    else if(sum>t) r--;
                    else{
                        ll.add(Arrays.asList(a[i], a[j], a[l], a[r]));                        
                        
                        while(l<r&&a[l]==a[l+1]) l++;
                        l++;
                        while(l<r&&a[r]==a[r-1]) r--;
                        r--;
                    }
                }
            }
        }

        return ll;
    }
}