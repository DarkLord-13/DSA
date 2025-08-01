class Solution{
    public List<Integer> findDuplicates(int[] nums){
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);            
        }  

        List<Integer> l = new ArrayList<>();
        for(int num: map.keySet()){
            if(map.get(num) > 1){
                l.add(num);
            }
        }      

        return l;
    }
}