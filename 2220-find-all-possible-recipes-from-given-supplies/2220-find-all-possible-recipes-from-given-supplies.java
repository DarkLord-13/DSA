class Solution {
    public List<String> findAllRecipes(String[] rec, List<List<String>> ing, String[] sup) {
        Map<String, List<String>> ingToRec = new HashMap<>();
        Map<String, Integer> recToIngReq = new HashMap<>();
        List<String> res = new ArrayList<>();

        for(int i=0; i<rec.length; i++){
            String r = rec[i];
            recToIngReq.put(r, ing.get(i).size());

            for(String in: ing.get(i)){
                if(!ingToRec.containsKey(in)){
                    ingToRec.put(in, new ArrayList<>());
                }

                ingToRec.get(in).add(r);
            }
        }

        Queue<String> q = new LinkedList<>();
        for(String s: sup) q.add(s);

        while(!q.isEmpty()){
            String item = q.poll();

            if(!ingToRec.containsKey(item)) continue;

            for(String r: ingToRec.get(item)){
                recToIngReq.put(r, recToIngReq.get(r) - 1);

                if(recToIngReq.get(r) == 0){
                    res.add(r);
                    q.add(r);
                    // map.remove(r);
                }
            }
        }

        return res;
    }
}