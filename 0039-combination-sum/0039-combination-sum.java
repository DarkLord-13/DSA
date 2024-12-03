class Solution{
    List<List<Integer>> ll = new ArrayList<>();
    int[] a; int t, n;
    public List<List<Integer>> combinationSum(int[] ax, int tx){
        a = ax; t = tx; n = a.length;

        f(0, 0, new ArrayList<>());

        return ll;
    }
    void f(int i, int sum, List<Integer> l){
        if(i==n && sum==t){
            ll.add(new ArrayList<>(l));
            return;
        }
        if(i>=n || sum>t) return;

        l.add(a[i]);
        f(i, sum+a[i], l);
        l.remove(l.size()-1);
        f(i+1, sum, l);
    }
}