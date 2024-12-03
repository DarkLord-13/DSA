class Solution{
    List<List<Integer>> ll = new ArrayList<>();
    int[] a; int target, n;
    public List<List<Integer>> combinationSum2(int[] ax, int tx){
        a = ax; target = tx; n = a.length;
        Arrays.sort(a);

        f(0, 0, new ArrayList<>());

        return ll;
    }
    void f(int i, int sum, List<Integer> l){        
        if(sum==target){
            ll.add(new ArrayList<>(l));
            return;
        }   

        for(int j=i; j<n; j++){
            if(j>i && a[j]==a[j-1]) continue;
            if(sum+a[j]>target) break;

            l.add(a[j]);
            f(j+1, sum+a[j], l);
            l.remove(l.size()-1);                      
        }
    }
}