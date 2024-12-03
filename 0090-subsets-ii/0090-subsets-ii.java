class Solution{
    int[] a; int n;
    Set<List<Integer>> ll = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] ax){
        a = ax; n = a.length;
        Arrays.sort(a);

        f(0, new ArrayList<>());

        List<List<Integer>> ret = new ArrayList<>();
        for(List<Integer> l: ll){
            //Collections.sort(l);
            ret.add(l);
        }
        return ret;
    }
    void f(int i, List<Integer> l){
        if(i>=n){
            ll.add(new ArrayList<>(l));
            return;
        }

        l.add(a[i]);
        f(i+1, l);
        l.remove(l.size()-1);
        f(i+1, l);
    }
}