class Solution{
    int[] a; int n;
    List<List<Integer>> ll = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] ax){
        a = ax; n = a.length;
        Arrays.sort(a);

        f(0, new ArrayList<>());
        
        return ll;
    }
    void f(int i, List<Integer> l){
        ll.add(new ArrayList<>(l));        

        for(int j=i; j<n; j++){
            if(j>i && a[j]==a[j-1]) continue;

            l.add(a[j]);
            f(j+1, l);

            l.remove(l.size()-1);
        }
    }
}