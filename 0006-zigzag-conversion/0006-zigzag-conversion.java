class Solution{
    public String convert(String s, int nr){
        if(nr == 1){
            return s;
        }

        int n = s.length();
        char[] c = s.toCharArray();
        List<StringBuilder> l = new ArrayList<>();
        for(int i=0; i<nr; i++){
            l.add(new StringBuilder());
        }        

        int r = 0, d = 0;
        for(int i=0; i<n; i++){
            if(r == 0){
                d = 1;
            }
            else if(r == nr-1){
                d = -1;
            }

            l.get(r).append(c[i]);

            r += d;
        }

        StringBuilder sb = new StringBuilder();
        for(StringBuilder t: l){
            sb.append(t);
        }

        return sb.toString();
    }
}