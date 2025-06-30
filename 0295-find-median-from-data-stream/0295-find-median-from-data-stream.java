class MedianFinder{
    PriorityQueue<Integer> min, max;

    public MedianFinder(){
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b)-> b-a);    
    }
    
    public void addNum(int num){
        min.add(num);
        max.add(min.poll());

        if(max.size() > min.size()){
            min.add(max.poll());
        }
    }
    
    public double findMedian(){
        if(min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
        }
        else{
            return min.peek();
        }
    }
}