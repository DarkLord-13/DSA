class Solution{
    List<List<Integer>> ll = new ArrayList<>(); int[] a; int n;
    public List<List<Integer>> permute(int[] ax){
        a = ax; n = a.length;

        f(new ArrayList<>(), new int[n]);

        return ll;
    }
    void f(List<Integer> l, int[] v){
        if(l.size()==n){
            ll.add(new ArrayList<>(l));
            return;
        }

        for(int i=0; i<n; i++){
            if(v[i]==0){
                l.add(a[i]);
                v[i] = 1;

                f(l, v);

                l.remove(l.size()-1);
                v[i] = 0;
            }
        }
    }
}