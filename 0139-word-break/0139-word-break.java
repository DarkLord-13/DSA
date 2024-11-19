class Solution{
    int l; String s; Set<String> set; boolean flag = false;
    Boolean[][] memo;
    public boolean wordBreak(String sx, List<String> wordDict){
        s = sx; l = s.length();
        set = new HashSet<>(wordDict);
        memo = new Boolean[l][l];

        boolean x = f(0, 0);
        return flag;
    }
    boolean f(int i, int j){
        System.out.println(i+" "+j);
        if(flag) return true;
        if(i>=l){
            flag = true;
            return true;
        }
        if(j>=l) return false;
        if(memo[i][j]!=null) return memo[i][j];
        
        //System.out.println(s.substring(i, j+1));
        boolean a = false;
        if(set.contains(s.substring(i, j+1))){
            //System.out.println(s.substring(i, j+1));
            if(j==l-1){
                //System.out.println(s.substring(i, j+1));
                flag = true;
            }
            a = f(j+1, j+1);
        }
        boolean b = f(i, j+1);

        return memo[i][j] = a||b;
    }
}