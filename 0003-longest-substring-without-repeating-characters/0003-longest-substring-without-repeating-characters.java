class Solution{
    public int lengthOfLongestSubstring(String s){
        int l = s.length(); 
        if(l<2) return l;
        int i = 0, j = 0, max = 0;
        HashSet<Character> set = new HashSet<>();

        while(j<l){
            char c = s.charAt(j);
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                max = Math.max(j-i, max);
                while(s.charAt(i)!=c){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }
            j++;
        }
        max = Math.max(max, j-i);

        return max;  
    }
}