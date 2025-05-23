class Solution{
    public int maximumLength(int[] a){
        int n = a.length;
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i: a){
            map.put((long)i, map.getOrDefault((long)i, 0)+1);
        } //System.out.println(map);

        int maxLen = 1;
        long maxV = 1_000_000_000L;
        for(long x: map.keySet()){
            if(map.get(x) <= 1){
                continue;
            }

            if(x == 1){
                int oneCount = map.get(x);
                if(oneCount%2 == 0){
                    oneCount--;
                }
                maxLen = Math.max(maxLen, oneCount);
                continue;
            }
            //System.out.println(x);
            
            long curr = x;
            int currLen = 1;
            int depth = 0;
            while(true){
                if(curr > maxV/curr) break;
                long next = curr*curr;
                if(map.containsKey(next)){
                    //System.out.println(curr + " " + next);
                    curr = next;
                    depth++;

                    if(map.get(next) < 2) break;
                }
                else{
                    break;
                }
            }

            maxLen = Math.max(maxLen, depth*2+1);
        }

        return maxLen;
    }
}