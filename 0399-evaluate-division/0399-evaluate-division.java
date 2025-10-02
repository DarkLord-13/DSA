class Solution{

    private class Pair{
        String v;
        double w;

        public Pair(String v, double w){
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return "{" + v + ", " + w + "}";
        }
    }

    public double[] calcEquation(
        List<List<String>> equations, 
        double[] values, 
        List<List<String>> queries){

        Map<String, List<Pair>> map = new HashMap<>();
        int i = 0;
        for(List<String> e: equations){
            String f = e.get(0), t = e.get(1);
            double w = values[i++];

            if(!map.containsKey(f)){
                map.put(f, new ArrayList<>());
            }
            map.get(f).add(new Pair(t, w));

            if(!map.containsKey(t)){
                map.put(t, new ArrayList<>());
            }
            map.get(t).add(new Pair(f, 1/w));
        }
        // System.out.println(map);


        double[] res = new double[queries.size()];
        i = 0;
        for(List<String> qr: queries){
            double p = 1.0;
            String s = qr.get(0), d = qr.get(1);

            if(!map.containsKey(s) || !map.containsKey(d)){
                res[i++] = -1;
                continue;
            }

            Queue<Pair> q = new LinkedList<>();
            q.add(new Pair(s, 1));

            boolean found = false;

            Set<String> seen = new HashSet<>();
            seen.add(s);

            
            while(!q.isEmpty()){
                Pair poll = q.poll();
                String curr = poll.v;
                double w = poll.w;

                if(curr.equals(d)){
                    found = true;
                    res[i++] = w;
                    break;
                }

                for(Pair next: map.getOrDefault(curr, new ArrayList<>())){
                    if(!seen.contains(next.v)){
                        q.add(new Pair(next.v, next.w * w));
                        seen.add(next.v);
                    }
                }                
            }

            if(!found) res[i++] = -1;
        }

        return res;
    }
}