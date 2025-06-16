class Solution{
    int n;
    int[] a;
    List<List<Integer>> ll = new ArrayList<>();
    public List<List<Integer>> subsets(int[] ax){
        a = ax;
        n = a.length;

        f(0, new ArrayList<>());

        return ll;
    }
    void f(int i, List<Integer> l){
        if(i >= n){
            ll.add(new ArrayList<>(l));
            return;
        }

        l.add(a[i]);
        f(i+1, l);
        l.remove(l.size()-1);
        f(i+1, l);        
    }
}