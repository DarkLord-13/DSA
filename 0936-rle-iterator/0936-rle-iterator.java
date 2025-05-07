class RLEIterator{
    int i, length;
    int[] e;
    
    public RLEIterator(int[] e){
        i = 0;
        this.e = e;
        length = e.length;        
    }
    
    public int next(int n){
        int ret = -1;
        while(i < length){
            if(e[i] >= n){                
                e[i] -= n;
                return e[i+1];
            }
            else{
                n -= e[i];
                i += 2;
            }
        }

        return ret;
    }
}