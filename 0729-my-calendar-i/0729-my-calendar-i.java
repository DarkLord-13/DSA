class MyCalendar{
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar(){
        calendar = new TreeMap<>();
    }
    
    public boolean book(int s, int e){
        Map.Entry<Integer, Integer> prev = calendar.floorEntry(s);
        if(prev != null && prev.getValue() > s) return false;

        Map.Entry<Integer, Integer> next = calendar.ceilingEntry(s);
        if(next != null && next.getKey() < e) return false;

        calendar.put(s, e);

        return true;
    }
}