class Solution{
    class Pair{
        int num, index;

        public Pair(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    public int findUnsortedSubarray(int[] a){
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y)->{
            if(x.num != y.num){
                return x.num - y.num;
            }
            else{
                return x.index - y.index;
            }
        });
        int n = a.length;

        for(int i=0; i<n; i++){
            q.add(new Pair(a[i], i));
        }

        int[] sorted = new int[n];
        int i = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            sorted[i++] = p.index;
        }
        // System.out.println(Arrays.toString(sorted));

        boolean first = false;
        int f = 0, l = 0;
        for(i=0; i<n; i++){
            if(sorted[i] != i){

                if(!first){
                    f = i;
                    l = i;
                    first = true;
                }

                l = i;
            }            
        }
        // System.out.println(f + " " + l);


        if(!first){
            return 0;
        }

        return l-f+1;
    }
}