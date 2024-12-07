class StockSpanner{
    class Pair{
        int p, c;
        public Pair(int p, int c){
            this.p=p; this.c=c;
        }
    }
    Stack<Pair> s;

    public StockSpanner(){
        s = new Stack<>();
    }
    
    public int next(int cp){
        if(s.size()==0){
            s.push(new Pair(cp, 1));
            return 1;
        }
        else{
            Pair peek = s.peek();
            int lp = peek.p, c = peek.c;
            if(cp>=lp){
                int days = 0;
                while(!s.isEmpty() && s.peek().p<=cp){
                    Pair pop = s.pop();
                    days += pop.c;
                }
                s.push(new Pair(cp, days+1));
                return days+1;
            }
            else{
                s.push(new Pair(cp, 1));
                return 1;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */