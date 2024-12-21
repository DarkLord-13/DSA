class Solution{
    char[] ch; int n; Boolean[][] memo;
    public boolean checkValidString(String s){
        ch = s.toCharArray(); 
        n = ch.length;
        memo = new Boolean[n+1][n+1];

        return f(0, 0);
    }
    boolean f(int i, int o){
        if(o<0)
            return false;
        if(memo[i][o]!=null) 
            return memo[i][o];                
        if(i>=n){
            if(o==0) 
                return memo[i][o] = true;
            else 
                return memo[i][o] = false;
        }

        boolean l=false, r=false, x=false;
        if(ch[i]=='('){
            l = f(i+1, o+1);
        }
        else if(ch[i]==')'){
            l = f(i+1, o-1);
        }
        else{
            l = f(i+1, o+1);
            r = f(i+1, o-1);
            x = f(i+1, o);
        }

        return memo[i][o] = l||r||x;
    }
}