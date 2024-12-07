class Solution{
    public int[] asteroidCollision(int[] arr){
        int n = arr.length;
        if(n<2) return arr;

        ArrayList<Integer> l = new ArrayList<>();
        for(int i: arr) l.add(i);
        while(true){
            
            boolean flag = true;
            for(int i=0; i<l.size()-1; i++){           

                int a = l.get(i), b = l.get(i+1);
                if(a>0&&b<0){ //opposite signs

                    a = Math.abs(a); b = Math.abs(b);
                    if(a<b) l.remove(i);
                    else if(b<a) l.remove(i+1);
                    else{ 
                        l.remove(i);
                        l.remove(i);
                    }
                    flag = false;
                }            
            }
            if(l.size()<2 || flag) break;            
        } 

        int[] ret = new int[l.size()];
        for(int i=0; i<l.size(); i++) ret[i]=l.get(i);
        return ret;
    }
}