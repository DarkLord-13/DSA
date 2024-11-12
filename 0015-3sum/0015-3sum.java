class Solution{
    public List<List<Integer>> threeSum(int[] a){
        Arrays.sort(a); int n = a.length;
        List<List<Integer>> ll = new ArrayList<>();

        int i=0;
        for(i=0; i<n-2; i++){
            
            int l=i+1, r=n-1;
            while(l<r){
                int sum = a[i] + a[l] + a[r];
                if(sum>0) r--;
                else if(sum<0) l++;
                else{
                    ll.add(Arrays.asList(a[i], a[l], a[r]));

                    while(l<r && a[l]==a[l+1]) l++; l++;
                    while(r>l && a[r]==a[r-1]) r--; r--;
                    while(i<n-2 && a[i]==a[i+1]) i++; 
                }                
            }            
        }

        return ll;
    }
}