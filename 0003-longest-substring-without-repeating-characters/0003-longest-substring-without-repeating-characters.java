class Solution{
    public int lengthOfLongestSubstring(String s){
        char[] arr = s.toCharArray();
        int l = 0, max = 0, n = arr.length;
        Set<Character> set = new HashSet<>();

        for(int r=0; r<n; r++){
            char c = arr[r];

            while(set.contains(c)){
                set.remove(arr[l]);
                l++;
            }

            max = Math.max(max, r - l + 1);

            set.add(c);
        }

        return max;
    }
}