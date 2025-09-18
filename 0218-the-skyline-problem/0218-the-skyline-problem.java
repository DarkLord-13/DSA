class Solution{
    public List<List<Integer>> getSkyline(int[][] buildings){
        List<int[]> events = new ArrayList<>();
        for(int[] b: buildings){
            int l = b[0], r = b[1], h = b[2];
            events.add(new int[] {l, -h});
            events.add(new int[] {r, h});
        }

        Collections.sort(events, (a, b) ->{
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> active = new TreeMap<>(Collections.reverseOrder());
        active.put(0, 1);
        int prevMax = 0;
        List<List<Integer>> res = new ArrayList<>();

        for(int[] ev: events){
            int x = ev[0], h = ev[1];

            if(h < 0){// start
                int height = -h;
                active.put(height, active.getOrDefault(height, 0) + 1);
            }
            else{
                int count = active.get(h);
                if(count == 1) active.remove(h);
                else active.put(h, count - 1);
            }

            int currMax = active.firstKey();
            if(currMax != prevMax){
                res.add(Arrays.asList(x, currMax));
                prevMax = currMax;
            }
        }

        return res;
    }
}
/**
2  - 10
3  - 15
4  - 15
5  - 15
6  - 15
7  - 15
8  - 12
9  - 12
10 - 12
11 - 12
12 - 12
15 - 10
16 - 10
17 - 10
18 - 10
19 - 10
20 - 10

 */