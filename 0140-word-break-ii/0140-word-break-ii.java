class Solution{

    private List<String> l;

    public List<String> wordBreak(String s, List<String> wordDict){
        this.l = new ArrayList<>();

        f(0, new StringBuilder(), s, new HashSet<>(wordDict));

        return l;
    }

    private void f(int i, StringBuilder sb, String s, Set<String> set){
        if(i >= s.length()){
            l.add(sb.toString().trim());
            return;
        }

        for(int j=i; j<s.length(); j++){
            if(set.contains(s.substring(i, j + 1))){
                sb.append(s.substring(i, j + 1)).append(" ");

                f(j + 1, sb, s, set);

                sb.delete(sb.length() - (j - i + 2), sb.length());
            }
        }
    }
}