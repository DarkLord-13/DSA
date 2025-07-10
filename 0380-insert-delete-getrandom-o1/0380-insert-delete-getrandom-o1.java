class RandomizedSet{
    List<Integer> l;
    Map<Integer, Integer> map;
    Random random;
    public RandomizedSet(){
        this.l = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }
    
    public boolean insert(int val){
        // System.out.println(l);
        if(map.containsKey(val)){
            return false;
        }
        else{
            l.add(val);
            map.put(val, l.size()-1);

            return true;
        }
        
    }
    
    public boolean remove(int val){
        // System.out.println(l);
        if(map.containsKey(val)){
            int lastVal = l.get(l.size() - 1);
            int valIndex = map.get(val);

            l.set(valIndex, lastVal);
            l.remove(l.size() - 1);
            
            map.remove(val);
            if(valIndex != l.size()) map.put(lastVal, valIndex);

            return true;
        }
        else{
            return false;
        }
    }
    
    public int getRandom(){
        int r = random.nextInt(l.size());

        return l.get(r);
    }
}