class Solution{
    class Visit{
        String u, s;
        int t;

        public Visit(String u, String s, int t){
            this.u = u;
            this.s = s;
            this.t = t;
        }

        @Override
        public String toString(){
            return u + " " + s + " " + t;
        }
    }
    
    public List<String> mostVisitedPattern(String[] u, int[] t, String[] w){
        int n = u.length;

        Visit[] visits = new Visit[n];
        for(int i=0; i<n; i++){
            visits[i] = new Visit(u[i], w[i], t[i]);
        }
        Arrays.sort(visits, (a, b)-> Integer.compare(a.t, b.t));

        Map<String, List<String>> byUser = new HashMap<>();
        for(Visit v: visits){
            if(!byUser.containsKey(v.u)){
                byUser.put(v.u, new ArrayList<>());                
            }
            byUser.get(v.u).add(v.s);
        } 
        System.out.println(byUser);

        Map<String, Integer> patternCount = new HashMap<>();
        for(Map.Entry<String, List<String>> entry: byUser.entrySet()){
            List<String> sites = entry.getValue();
            int m = sites.size();
            Set<String> seenUser = new HashSet<>();

            for(int i=0; i<m-2; i++){
                for(int j=i+1; j<m-1; j++){
                    for(int k=j+1; k<m; k++){
                        String key = sites.get(i) + "#" 
                                   + sites.get(j) + "#" 
                                   + sites.get(k);
                                   
                        if(seenUser.add(key)){                          
                            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
                        }
                    }
                }
            }
        }

        int bestScore = 0;
        String bestPattern = "";
        for (Map.Entry<String, Integer> e : patternCount.entrySet()) {
            String pat = e.getKey();
            int cnt = e.getValue();
            if (cnt > bestScore || (cnt == bestScore && pat.compareTo(bestPattern) < 0)) {
                bestScore = cnt;
                bestPattern = pat;
            }
        }
        
        // 5. Split the winning key back into a List<String>
        return Arrays.asList(bestPattern.split("#"));
    }
}