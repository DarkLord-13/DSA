class Solution{
    public String removeKdigits(String num, int k){
        Stack<Integer> s = new Stack<>();
        for(char c: num.toCharArray()){
            int d = c-'0';
            while(k>0 && !s.isEmpty() && s.peek()>d){
                s.pop();
                k--;
            }
            s.push(d);
        }
        while(k>0&&!s.isEmpty()){
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.insert(0, s.pop());
        } System.out.println(sb);

        String ns = sb.toString();
        int i = 0;
        while(i<ns.length()&&ns.charAt(i)=='0') 
            i++;
        ns = ns.substring(i, ns.length());

        if(ns.equals("")) return "0";
        return ns;
    }
}