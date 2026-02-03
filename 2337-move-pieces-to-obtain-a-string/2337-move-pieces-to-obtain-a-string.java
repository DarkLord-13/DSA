class Solution{
    private class Pair{
        char c;
        int i;

        public Pair(char c, int i){
            this.c = c;
            this.i = i;
        }
    }
    public boolean canChange(String start, String target){
        char[] s = start.toCharArray();
        char[] t = target.toCharArray();
        int n = s.length;
        List<Pair> sl = new ArrayList<>(), tl = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(s[i] != '_'){
                sl.add(new Pair(s[i], i));
            }
            if(t[i] != '_'){
                tl.add(new Pair(t[i], i));
            }
        }

        if(sl.size() != tl.size()) return false;

        for(int i=0; i<sl.size(); i++){
            Pair a = sl.get(i), b = tl.get(i);

            if(a.c != b.c) return false;            
            else if(a.c == 'R'){
                if(a.i > b.i) return false;
            }
            else{
                if(a.i < b.i) return false;
            }
        }

        return true;
    }
}