class Solution{
    public int furthestBuilding(int[] h, int b, int l){
        int n = h.length;
        int[] diff = new int[n - 1];
        for(int i=0; i<n-1; i++){
            diff[i] = Math.max(0, h[i+1] - h[i]);
        }
        // System.out.println(Arrays.toString(diff));

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i=0; i<n-1; i++){
            if(diff[i] != 0){
                q.add(diff[i]);

                if(q.size() > l){
                    b -= q.poll();
                    q.add(99999999);
                    if(b < 0){
                        return i;
                    }
                }
            }
        }

        return n - 1;
    }
}