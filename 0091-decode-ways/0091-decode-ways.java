class Solution{
    String s; int l; Integer[] memo;
    public int numDecodings(String sx){
        s = sx; l = s.length();
        if(s.charAt(0)=='0') return 0;
        memo = new Integer[l];

        return f(0);
    }
    int f(int i){
        if(i==l) return 1;
        if(i>l) return 0;
        if(memo[i]!=null) return memo[i];

        char c1 = s.charAt(i);
        int a = 0, b = 0;

        if(c1=='0') return 0;
        else{
            if(i<l-1){
                int y = Integer.valueOf(s.substring(i, i+2));
                if(y>9&&y<27)
                    a = f(i+2);
            }
            b = f(i+1);
        }        

        return memo[i] = a+b;
    }
}