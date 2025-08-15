class Solution{
    Map<String, PriorityQueue<String>> map;
    List<String> res;
    public List<String> findItinerary(List<List<String>> ll){
        map = new HashMap<>();
        res = new ArrayList<>();

        for(List<String> l: ll){
            String from = l.get(0), to = l.get(1);

            if(!map.containsKey(from)) map.put(from, new PriorityQueue<>());
            map.get(from).add(to);
        }
        // System.out.println(map);

        f("JFK");        

        return res;
    }
    private void f(String a){
        PriorityQueue<String> q = map.get(a);
        // if(q == null) return;

        while(q != null && !q.isEmpty()){
            f(q.poll());
        }

        res.addFirst(a);
    }
}