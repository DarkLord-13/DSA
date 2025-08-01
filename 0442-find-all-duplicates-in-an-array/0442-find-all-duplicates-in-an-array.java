class Solution{
    public List<Integer> findDuplicates(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();

        for(int i: nums){
            if(!set.contains(i)){
                set.add(i);
            }
            else{
                l.add(i);
            }
        }

        return l;
    }
}