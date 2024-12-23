class Solution{
    public List<List<Integer>> generate(int n){
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(new ArrayList<>(Arrays.asList(1)));

        for(int j=1; j<=n; j++){
            List<Integer> l = new ArrayList<>();            

            for(int i=0; i<j; i++){
                int add = 0;

                if(i-1>=0){
                    add+=(ll.get(j-1).get(i-1));
                }
                if(i<ll.get(j-1).size()){
                    add+=(ll.get(j-1).get(i));
                }

                l.add(add);
            }
            ll.add(new ArrayList<>(l));
        }

        ll.remove(Arrays.asList(1));
        return ll;
    }
}