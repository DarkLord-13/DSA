class Solution{
    public String countAndSay(int n){
        if(n==1){
            return "1";
        }
        if(n==2){
            return "11";
        }
        
        String prev = "11";
        for(int i=3; i<=n; i++){
            String next = "";
            char c = prev.charAt(0);
            int freq = 1;
            int j = 1;
            while(j<prev.length()){
                if(prev.charAt(j)==c){
                    freq++;
                }
                else{
                    next = next + Integer.toString(freq) + Character.toString(c);
                    c = prev.charAt(j);
                    freq = 1;
                }
                j++;
            }
            next = next + Integer.toString(freq) + Character.toString(c);
            prev = next;
        }

        return prev;
    }
}