class Solution{
    public boolean containsNearbyDuplicate(int[] a, int k){
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            if(map.containsKey(a[i])){
                int li = map.get(a[i]);
                if(i-li <= k){
                    return true;
                }
            }
            
            map.put(a[i], i);            
        }

        return false;
    }
}