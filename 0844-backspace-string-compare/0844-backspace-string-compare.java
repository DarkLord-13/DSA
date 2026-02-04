class Solution{
    public boolean backspaceCompare(String ss, String tt){
        int i = ss.length() - 1, j = tt.length() - 1;
        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        while(i >= 0 || j >= 0){
            i = f(i, s);
            j = f(j, t);

            if(i < 0 && j < 0) return true;
            else if(i < 0 || j < 0) return false;

            if(s[i] != t[j]) return false;

            i--;
            j--;
        }

        return i < 0 && j < 0;
    }

    private int f(int i, char[] s){
        int skip = 0;

        while(i >= 0){
            if(s[i] == '#'){
                skip++;
                i--;
            }
            else if(skip > 0){
                i--;
                skip--;
            }
            else break;
        }

        return i;
    }
}