class Solution{
    class Pair{
        String curr;
        Set<String> set = new HashSet<>();

        public Pair(String curr, Set<String> set){
            this.curr = curr;
            this.set = set;
        }
    }
    public int ladderLength(String begin, String end, List<String> l){
        if(!l.contains(end)){
            return 0;
        }

        int n = l.size();
        Map<String, List<String>> map = new HashMap<>();

        if(!l.contains(begin)){
            List<String> v = new ArrayList<>();

            for(int j=0; j<n; j++){
                if(match(begin, l.get(j))){
                    v.add(l.get(j));
                }
            }
            map.put(begin, v);
        }
        for(int i=0; i<n; i++){
            String s = l.get(i);
            List<String> v = new ArrayList<>();

            for(int j=0; j<n; j++){
                if(i!=j && match(s, l.get(j))){
                    v.add(l.get(j));
                }
            }

            map.put(s, v);
        } //System.out.println(map);
        

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(begin, new HashSet<>()));
        int steps = 0;

        while(!q.isEmpty()){
            steps++;            

            int s = q.size();
            for(int x=0; x<s; x++){
                Pair poll = q.poll();
                String curr = poll.curr;
                Set<String> set = poll.set;

                if(curr.equals(end)){
                    return steps;
                }

                for(String next: map.get(curr)){
                    if(!set.contains(next)){
                        set.add(next);
                        q.add(new Pair(next, set));
                    }
                }
            }
        }

        return 0;
    }
    boolean match(String a, String b){
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();

        int c = 0;
        for(int i=0; i<a.length(); i++){
            if(x[i]!=y[i]){
                c++;
            }
        }

        if(c==1){
            return true;
        }
        else{
            return false;
        }
    }
}