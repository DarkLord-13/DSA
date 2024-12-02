class Solution{
    public int[] findErrorNums(int[] a){
        HashSet<Integer> set = new HashSet<>();
        int d = 0, n = a.length, sum = (n*(n+1))/2;
        for(int i: a){
            if(set.contains(i)){
                d = i;
                continue;
            }
            set.add(i);
            sum -= i;
        }
        return new int[]{d, sum};
    }
}