class Solution{
    private class Pair{
        String s;
        int f;

        public Pair(String s, int f){
            this.s = s;
            this.f = f;
        }
    }
    public List<String> topKFrequent(String[] words, int k){
        HashMap<String, Integer> map = new HashMap<>();
        for(String w: words) map.put(w, map.getOrDefault(w, 0) + 1);

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> {
            if(a.f != b.f) return a.f - b.f;
            else return -a.s.compareTo(b.s);
        });

        for(var e: map.entrySet()){
            q.add(new Pair(e.getKey(), e.getValue()));

            if(q.size() > k) q.poll();
        }
        
        List<String> l = new ArrayList<>();
        while(!q.isEmpty()){
            l.add(0, q.poll().s);
        }

        return l;
    }
}