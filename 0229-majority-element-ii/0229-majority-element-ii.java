class Solution{
    public List<Integer> majorityElement(int[] a){
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>(n);
        HashSet<Integer> l = new HashSet<>();

        for(int i: a){
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i)>(n/3)) l.add(i);
        }

        return new ArrayList<>(l);
    }
}