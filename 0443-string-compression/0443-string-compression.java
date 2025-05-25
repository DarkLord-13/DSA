class Solution{
    public int compress(char[] chars){
        int n = chars.length;
        int count = 1;
        int j = 0;
        for(int i=1; i<n; i++){
            if(chars[i] == chars[i-1]){
                count++;
                continue;
            }
            
            chars[j++] = chars[i-1];
            if(count > 1){
                String s = Integer.toString(count);
                char[] c = s.toCharArray();
                for(char d: c){
                    chars[j++] = d;
                }
            }

            count = 1;
        }
        chars[j++] = chars[n-1];
        if(count > 1){
            String s = Integer.toString(count);
            char[] c = s.toCharArray();
            for(char d: c){
                chars[j++] = d;
            }
        }

        return j;
    }
}