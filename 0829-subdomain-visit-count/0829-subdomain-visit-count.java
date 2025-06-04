class Solution{
    public List<String> subdomainVisits(String[] dom){
        int n = dom.length;
        Map<String, Integer> map = new HashMap<>();

        for(String s: dom){
            String[] parts = s.split(" ");
            int f = Integer.valueOf(parts[0]);
            String website = parts[1];

            map.put(website, map.getOrDefault(website, 0) + f);

            for(int i=1; i<website.length(); i++){
                if(website.charAt(i) == '.'){
                    String subWebsite = website.substring(i+1, website.length());
                    map.put(subWebsite, map.getOrDefault(subWebsite, 0) + f);
                }
            }
        }

        List<String> l = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            l.add(Integer.toString(entry.getValue()) + " " + entry.getKey());
        }

        return l;
    }
}