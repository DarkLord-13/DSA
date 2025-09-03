class Solution{
    public int[] topKFrequent(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)-> {
            return a[1] - b[1];
        });

        for(var e: map.entrySet()){
            q.add(new int[] {e.getKey(), e.getValue()});

            if(q.size() > k){
                q.poll();
            }
        }

        int[] ret = new int[k];
        int i = 0;
        while(!q.isEmpty()) ret[i++] = q.poll()[0];

        return ret;
    }
}