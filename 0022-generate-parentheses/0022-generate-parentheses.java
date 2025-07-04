class Solution{
    List<String> l;
    int n;
    public List<String> generateParenthesis(int n){
        this.l = new ArrayList<>();
        this.n = n;

        f(0, 0, new StringBuilder());

        return l;
    }
    void f(int o, int c, StringBuilder sb){
        if(o == n && c == n){
            l.add(new String(sb.toString()));
            return;
        }

        // System.out.println(sb);
        if(o < n){
            sb.append('(');
            f(o+1, c, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(o > c){
            sb.append(')');
            f(o, c+1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }        
        // if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
    }
}