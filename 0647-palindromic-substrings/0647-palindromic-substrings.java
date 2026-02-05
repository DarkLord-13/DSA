class Solution{
    public int countSubstrings(String s){
        int n = s.length(), count = 0;

        for(int i=0; i<n; i++){
            count += f(i, i + 1, s);
            count += f(i - 1, i + 1, s);
            count++;
        }

        return count;
    }

    private int f(int l, int r, String s){
        int count = 0;
        
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) == s.charAt(r)){
                l--;
                r++;
                count++;
            }
            else break;
        }

        return count;
    }
}