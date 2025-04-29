class Solution{
    List<List<String>> ll = new ArrayList<>();
    String s;
    int n;
    public List<List<String>> partition(String sx){
        s = sx;
        n = s.length();

        f(0, new ArrayList<>());

        return ll;
    }
    void f(int i, List<String> l){
        if(i >= n){
            ll.add(new ArrayList<>(l));
            return;
        }

        for(int j=i; j<n; j++){
            if(isPalindrome(i, j)){
                l.add(s.substring(i, j+1));
                f(j+1, l);
                l.remove(l.size()-1);
            }
        }
    }
    boolean isPalindrome(int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}