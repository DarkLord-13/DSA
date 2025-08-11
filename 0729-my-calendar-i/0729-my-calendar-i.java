class MyCalendar{
    private List<List<Integer>> ll;

    public MyCalendar(){
        this.ll = new ArrayList<>();
    }
    
    public boolean book(int s, int e){
        for(List<Integer> l: this.ll){
            if(s < l.get(1) && e > l.get(0)){
                return false;
            }
        }

        ll.add(Arrays.asList(s, e));

        return true;
    }
}