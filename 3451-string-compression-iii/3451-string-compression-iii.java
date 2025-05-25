class Solution{
    public String compressedString(String s){
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int n = s.length();
        int count = 1;
        for(int i=1; i<n; i++){
            if(c[i] == c[i-1]){
                count++;
            }
            else{
                while(count > 9){
                    sb.append(9);
                    sb.append(c[i-1]);
                    count -= 9;
                }
                sb.append(count);
                sb.append(c[i-1]);                
                count = 1;
            }
        }
        while(count > 9){
            sb.append(9);
            sb.append(c[n-1]);
            count -= 9;
        }
        sb.append(count);
        sb.append(c[n-1]);        

        return sb.toString();
    }
}