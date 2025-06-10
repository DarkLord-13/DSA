class Solution{
    public String longestPalindrome(String s){
        int n = s.length();
        int max = 1, li = 0, ri = 0;

        for(int i=0; i<n; i++){
            int l = i-1, r = i+1;

            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }

            if(r-l+1 > max){
                max = r-l+1;
                li = l;
                ri = r;
            }

            if(i < n-1){
                l = i; r = i+1;

                while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                    l--;
                    r++;
                }

                if(r-l+1 > max){
                    max = r-l+1;
                    li = l;
                    ri = r;
                }          
            }
        }

        return s.substring(li+1, ri);
    }
}