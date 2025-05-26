class Solution{
    public long continuousSubarrays(int[] a){
        int n = a.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long count = 0;
        int i = 0;

        for(int j=0; j<n; j++){
            map.put(a[j], map.getOrDefault(a[j], 0) + 1);

            while(map.lastKey() - map.firstKey() > 2){
                map.put(a[i], map.get(a[i]) - 1);

                if(map.get(a[i]) == 0){
                    map.remove(a[i]);
                }
                i++;
            }

            count += (j-i+1);
        }

        return count;
    }
}