class Solution{
    public int maxSumDistinctTriplet(int[] x, int[] y){
        int n = x.length;
        HashMap<Integer, Integer> map = new HashMap<>(); // <x[i], max(y[i])>
        for(int i=0; i<n; i++){
            if(map.containsKey(x[i])){
                map.put(x[i], Math.max(map.get(x[i]), y[i]));
            }
            else{
                map.put(x[i], y[i]);
            }
        }

        if(map.size() < 3){
            return -1;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b)-> b-a);
        q.addAll(map.values());

        return q.poll() + q.poll() + q.poll();
    }
}