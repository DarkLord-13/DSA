class Solution{
    public int minSwaps(String sx){
        int w = 0; char[] arr = sx.toCharArray();
        Stack<Character> s = new Stack<>();

        for(char c: arr){
            if(c=='[') s.push(c);
            else{
                if(s.size()>0){
                    char pop = s.pop();
                    if(pop!='[') w++;
                }
                else w++;
            }
        }

        return (int)((w+1)/2);
    }
}