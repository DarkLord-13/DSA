class Solution{
    public String getPermutation(int n, int k){
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<n; i++){
            fact *= i;
            numbers.add(i);
        } numbers.add(n);

        StringBuilder sb = new StringBuilder();
        k-=1;
        while(true){
            sb.append(numbers.get(k/fact));
            numbers.remove(k/fact);

            if(numbers.size()==0) break;

            k = k%fact;
            fact = fact/numbers.size();
        }

        return sb.toString();
    }
}