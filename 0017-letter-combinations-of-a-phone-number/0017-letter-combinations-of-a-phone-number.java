class Solution{
    char[] c;
    int n;
    List<String> l = new ArrayList<>();
    HashMap<Character, List<Character>> map = new HashMap<>();
    public List<String> letterCombinations(String digits){
        c = digits.toCharArray();
        n = digits.length();       
        if(n == 0){
            return l;
        } 
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        f(0, new StringBuilder());

        return l;
    }
    void f(int i, StringBuilder sb){
        if(i >= n){
            l.add(sb.toString());
            return;
        }
        //System.out.println(c[i]);
        List<Character> letters = map.get(c[i]);
        for(char key: letters){
            sb.append(key);
            f(i+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}