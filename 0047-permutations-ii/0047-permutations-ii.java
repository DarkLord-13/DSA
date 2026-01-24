class Solution{
    List<List<Integer>> ll;
    int n;
    public List<List<Integer>> permuteUnique(int[] nums){
        this.ll = new ArrayList<>();
        this.n = nums.length;
        Arrays.sort(nums);

        List<Integer> l = new ArrayList<>();
        for(int num: nums) l.add(num);

        f(0, l);

        return ll;
    }
    void f(int i, List<Integer> l){
        if(i >= n){
            ll.add(new ArrayList<>(l));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int j=i; j<n; j++){
            if(set.contains(l.get(j))) continue;
            else set.add(l.get(j));

            swap(i, j, l);
            f(i+1, l);
            swap(i, j, l);
        }
    }
    void swap(int i, int j, List<Integer> l){
        int temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }
}