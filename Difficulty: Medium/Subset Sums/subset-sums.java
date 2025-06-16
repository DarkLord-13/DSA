class Solution{
    ArrayList<Integer> l = new ArrayList<>();
    int n;
    int[] arr;
    public ArrayList<Integer> subsetSums(int[] arrx){
        arr = arrx;
        n = arr.length;
        
        f(0, 0);
        
        return l;
    }
    void f(int i, int sum){
        l.add(sum);
        
        for(int j=i; j<n; j++){
            sum += arr[j];
            f(j+1, sum);
            sum -= arr[j];
        }
    }
}