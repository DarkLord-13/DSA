class Solution{
    public String getSmallestString(String s, int k){
        if(k == 0){
            return s;
        }
        int n = s.length();
        char[] a = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < n){
            if(k > 0){
                if('z'-a[i] <= a[i]-'a' && 'z'-a[i] < k){
                    sb.append('a');
                    k -= ('z'-a[i]+1);
                }
                else{
                    if(k > a[i]-'a'){
                        sb.append('a');
                        k -= (a[i]-'a');
                    }
                    else{
                        sb.append((char)(a[i] - k));
                        k = 0;
                    }
                }
            }
            else break;

            i++;
        }

        while(i < n){
            sb.append(a[i]);
            i++;
        }

        return sb.toString();
    }
}