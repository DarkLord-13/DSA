class Solution{
    public int numberOfSubstrings(String s){
        int i=0, j=0, l=s.length(), max=0, sub=0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] a = s.toCharArray();

        while(j<l){
            map.put(a[j], map.getOrDefault(a[j], 0)+1);       

            while(map.size()==3){
                sub+=(l-j);
                map.put(a[i], map.get(a[i])-1);
                if(map.get(a[i])==0) map.remove(a[i]);                    
                i++;
            }            
            j++;            
        } 

        return sub;
    }
}