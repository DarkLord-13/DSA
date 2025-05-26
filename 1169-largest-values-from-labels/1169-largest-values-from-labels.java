class Solution{
    class Pair{
        int v, l;

        public Pair(int v, int l){
            this.v = v;
            this.l = l;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit){
        int n = values.length;
        PriorityQueue<Pair> q = new PriorityQueue<>((a, b)-> b.v-a.v);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            q.add(new Pair(values[i], labels[i]));
            map.put(labels[i], 0);
        }

        int sum = 0, items = 0;
        while(!q.isEmpty()){
            Pair poll = q.poll();
            int v = poll.v;
            int l = poll.l;

            if(map.get(l) < useLimit){
                sum += v;
                items++;
                map.put(l, map.get(l) + 1);
            }

            if(items == numWanted){
                break;
            }
        }

        return sum;
    }
}