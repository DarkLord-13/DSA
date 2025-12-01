class Solution{
    public List<List<Integer>> groupThePeople(int[] gs){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int g: gs){
            if(!map.containsKey(g)) map.put(g, new ArrayList<>());
        }

        List<List<Integer>> ll = new ArrayList<>();
        for(int i=0; i<gs.length; i++){
            int g = gs[i];
            
            if(map.get(g).size() >= g){
                ll.add(new ArrayList<>(map.get(g)));
                map.put(g, new ArrayList<>());
            }

            map.get(g).add(i);
        }

        for(var e: map.entrySet()){
            ll.add(e.getValue());
        }

        return ll;
    }
}