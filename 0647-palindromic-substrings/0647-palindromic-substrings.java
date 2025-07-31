class Solution{
    private static char[] s;
    private static int n;
    public int countSubstrings(String str){
        this.n = str.length();
        this.s = str.toCharArray();

        if(n <= 1) return n;
        
        int pals = n;
        for(int i=1; i<n; i++){
            pals += countPals(i-1, i);
            pals += countPals(i-1, i+1);
        }

        return pals;
    }
    int countPals(int i, int j){
        if(i < 0 || j >= n) return 0;

        int pals = 0;
        while(i >= 0 && j < n){
            if(s[i] == s[j]){
                i--;
                j++;
                pals++;
            }
            else{
                break;
            }
        }

        return pals;
    }
}