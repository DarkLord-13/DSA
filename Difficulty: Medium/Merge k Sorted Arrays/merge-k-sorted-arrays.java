class Solution{
    class Pair{
        int eleIndex;
        int listIndex;
        int num;
        
        public Pair(int eleIndex, int listIndex, int num){
            this.eleIndex = eleIndex;
            this.listIndex = listIndex;
            this.num = num;
        }
    }
    public ArrayList<Integer> mergeKArrays(int[][] arr, int k){
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) ->{
            return a.num - b.num;
        });
        
        for(int i=0; i<k; i++){
            q.add(new Pair(0, i, arr[i][0]));
        }
        
        ArrayList<Integer> l = new ArrayList<>();
        
        while(!q.isEmpty()){
            Pair poll = q.poll();
            l.add(poll.num);
            
            if(poll.eleIndex < k-1){
                q.add(new Pair(poll.eleIndex+1, poll.listIndex, arr[poll.listIndex][poll.eleIndex+1]));
            }
        }
        
        return l;
    }
}