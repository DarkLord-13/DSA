class Solution{
    public int subarraysWithKDistinct(int[] a, int k){
        return f(a, k)-f(a, k-1);
    }
    int f(int[] a, int k){
        if(k<0) return 0;

        int l=0, r=0, n=a.length, c=0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r<n){
            map.put(a[r], map.getOrDefault(a[r], 0)+1);
            
            while(map.size()>k){
                map.put(a[l], map.get(a[l])-1);
                if(map.get(a[l])==0) 
                    map.remove(a[l]);
                l++;
            }
            c+=(r-l+1);
            r++;
        }

        return c;
    }
}