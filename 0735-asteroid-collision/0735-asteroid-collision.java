class Solution{
    public int[] asteroidCollision(int[] a){
        int n = a.length, i = 0;
        Stack<Integer> s = new Stack<>();
        while(i<n){
            if(s.isEmpty()){
                s.push(a[i]);
                i++;
            }
            else{
                if(s.peek()>0&&a[i]<0){
                    int x = Math.abs(s.peek()), y = Math.abs(a[i]);
                    if(x<y) s.pop();
                    else if(y<x) i++;
                    else{
                        s.pop();
                        i++;
                    }
                }
                else{
                    s.push(a[i]);
                    i++;
                }
            }
            //i++;
        }

        n = s.size();
        int[] ret = new int[n];
        for(i=n-1; i>=0; i--) ret[i]=s.pop();

        return ret;
    }
}