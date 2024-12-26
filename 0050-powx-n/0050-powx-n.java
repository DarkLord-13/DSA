class Solution{
    public double myPow(double x, int n){
        if(x==0) return x;
        if(n==0) return 1.0; 

        long exp = n;
        if(n<0){
            x = 1/x;
            exp = -exp;
        }

        double ans = 1;
        while(exp>0){
            if(exp%2!=0){
                ans = ans*x;
            }
            x = x*x;
            exp = exp/2;
            
            //System.out.println(ans+"--"+exp);
        }

        return ans;
    }
}