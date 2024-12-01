class Solution{
    int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
    public int myAtoi(String s){
        s = s.trim();
        int l = s.length();
        if(l==0) return l;
        boolean positive = true;
        int i = -1;
        while(i<l){
            i+=1;
            char c = s.charAt(i);
            if(isDigit(c)) break;
            else if(c==' ') continue;
            else if(c=='+') break;
            else if(c=='-'){
                positive = false;
                break;
            }
            else return 0;
        }

        int x = i;
        if(!isDigit(s.charAt(i))) x+=1; System.out.println(x);

        int ret = 0; boolean firstTime = true;
        for(i=x; i<l; i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                int d = c-'0';
                firstTime = false;
                /*if(firstTime){
                    firstTime = false;
                    ret = d;
                    continue;
                }*/

                if(max/10<ret || (max/10==ret && max%10<d)){
                    if(positive) return max; return min;
                }
                ret = ret * 10 + d;
                System.out.println(ret);
            }
            else break;
        }

        if(firstTime) return 0;

        if(!positive){
            if(ret*-1<=min) return min;
            ret = ret*-1;
        }
        return ret;
    }
    boolean isDigit(char c){
        if(c-'0'>=0&&c-'0'<=9) return true;
        return false;
    }
}