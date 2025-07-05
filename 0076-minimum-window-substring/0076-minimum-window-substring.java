class Solution{
    public String minWindow(String ss, String tt){
        int m = ss.length();
        int n = tt.length();

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>(); 

        char[] s = ss.toCharArray();
        char[] t = tt.toCharArray();

        for(char c: t){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        } 
        // System.out.println(mapT);

        int required = mapT.size();
        int satisfied = 0;

        int i = 0, j = 0;
        int ml = Integer.MAX_VALUE, mini = 0, minj = 0;

        while(j < m){           
            if(mapT.containsKey(s[j])){ 
                mapS.put(s[j], mapS.getOrDefault(s[j], 0) + 1);

                if(mapS.get(s[j]).equals(mapT.get(s[j]))){
                    satisfied++;
                }                
            }
            while(satisfied == required){
                // System.out.println(mapS);
                int cl = j-i+1;
                if(cl < ml){
                    ml = cl;
                    mini = i;
                    minj = j;
                }

                if(mapS.containsKey(s[i])){
                    mapS.put(s[i], mapS.get(s[i]) - 1);

                    if(mapS.get(s[i]) == mapT.get(s[i]) - 1){
                        satisfied--;
                    }

                    if(mapS.get(s[i]) == 0){
                        mapS.remove(s[i]);
                    }
                }

                i++;
            }

            j++;
        }        
        

        if(ml == Integer.MAX_VALUE){
            return "";
        }
        else{
            return ss.substring(mini, minj+1);
        }
    }
}