class Solution{
    int[] parent;
    int[] r;
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return;
        }

        if(r[x]>r[y]){
            parent[y] = x;
        }
        else if(r[y]>r[x]){
            parent[x] = y;
        }
        else{
            parent[y] = x;
            r[x]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts){
        int n = accounts.size();
        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        r = new int[n];
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String iMail = accounts.get(i).get(j);
                if(map.containsKey(iMail)){
                    union(i, map.get(iMail));
                }
                else{
                    map.put(iMail, i);
                }
            }
        }

        for(int i=0; i<n; i++){
            parent[i] = find(parent[i]);
        }

        List<List<String>> ret = new ArrayList<>();
        for(int i=0; i<n; i++){
            ret.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> iter: map.entrySet()){
            String mail = iter.getKey();
            int parent = iter.getValue();
            int ultimateParent = find(parent);            

            ret.get(ultimateParent).add(mail);
        }

        List<List<String>> sorted = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(ret.get(i).size()>0){
                List<String> l = ret.get(i);
                Collections.sort(l);
                l.add(0, accounts.get(i).get(0));
                sorted.add(l);
            }
        }

        return sorted;
    }
    void print(int[] arr){
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}