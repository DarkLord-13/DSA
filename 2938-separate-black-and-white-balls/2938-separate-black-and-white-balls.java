class Solution{
    private class Pair{
        int b, i;

        public Pair(int b, int i){
            this.b = b;
            this.i = i;
        }
    }
    public long minimumSteps(String s){
        int n = s.length();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = s.charAt(i) - '0';
        }

        List<Long> og = f(nums);
        Arrays.sort(nums);
        List<Long> sorted = f(nums);

        long swaps = 0;
        for(int i=0; i<og.size(); i++){
            swaps += (sorted.get(i) - og.get(i));
        }

        return swaps;
    }

    private List<Long> f(int[] nums){
        List<Long> oneIndex = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) oneIndex.add(i * 1L);
        }

        return oneIndex;
    }
}
/**
101
011

100
001

0111

011010
000111   3
 */