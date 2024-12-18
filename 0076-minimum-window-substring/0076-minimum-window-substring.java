class Solution{
    HashMap<Character, Integer> mapT = new HashMap<>();
    HashMap<Character, Integer> mapS = new HashMap<>();
    public String minWindow(String s, String t){
       char[] a = s.toCharArray();       
       int l=0, r=0, n=a.length, mini=0, minj=n+5;

       for(char c: t.toCharArray()){
           mapT.put(c, mapT.getOrDefault(c, 0)+1);
       } System.out.println(mapT);

       while(r<n){
           if(mapT.containsKey(a[r])){
                mapS.put(a[r], mapS.getOrDefault(a[r], 0)+1);
            } System.out.println(mapS);

           if(allExists()){
                if(r-l<minj-mini){
                    minj=r; mini=l;
                }

                while(allExists()){
                    if(mapT.containsKey(a[l]))
                        mapS.put(a[l], mapS.get(a[l])-1);
                    l++;

                    if(!allExists()){
                        if(r-(l-1)<minj-mini){
                            minj=r; mini=l-1;
                        }
                    }
                }
                
            }
            r++;
       }

        if(minj==n+5) return "";
       return s.substring(mini, minj+1);
    }
    boolean allExists(){
        if(mapT.size()!=mapS.size()) return false;
        for(Map.Entry<Character, Integer> entry: mapS.entrySet()){
            //System.out.println(entry.getKey()+"-"+entry.getValue());
            //System.out.println(map);

            if(entry.getValue()<mapT.get(entry.getKey())) 
                return false;
        }
        return true;
    }
}