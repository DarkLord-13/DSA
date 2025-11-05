class Solution{
    public String[] splitMessage(String message, int limit){
        char[] s = message.toCharArray();
        int n = s.length;

        int totalParts = findMinimalParts(n, limit);

        if(totalParts <= 0) return new String[0];

        String tp = Integer.toString(totalParts);

        String[] ans = new String[totalParts];
        int part = 1;        
        int i = 0, j = 0;
        int taken = 3 + tp.length();
        

        while(i < n){
            int chars = limit - (taken + Integer.toString(part).length());

            if(chars <= 0) return new String[0];

            StringBuilder sb = new StringBuilder();
            sb.append(message.substring(i, Math.min(i + chars, n)));
            sb.append("<" + Integer.toString(part) + "/" + tp + ">");
            ans[j++] = sb.toString();

            i += chars;
            part++;
        }

        return ans;
    }

    private int findMinimalParts(int n, int limit) {
        int maxDigits = Integer.toString(n).length();
        int best = Integer.MAX_VALUE;

        for(int digits=1; digits<=maxDigits; digits++){
            int maxPartsForDigit = Math.min(n, (int)Math.pow(10, digits) - 1);
            int part = 1, i = 0;
            boolean isMaxPartSufficient = true;
            
            while(i < n){
                int chars = limit - (3 + Integer.toString(part).length() + digits);
                if(chars <= 0){
                    isMaxPartSufficient = false;
                    break;
                }

                int next = i + chars;

                if(next >= n){
                    break;
                }         
                else{
                    i = next;
                    part++;

                    if(part > maxPartsForDigit){
                        isMaxPartSufficient = false;
                        break;
                    }
                }   
            }

            if(isMaxPartSufficient) best = Math.min(best, part);
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}