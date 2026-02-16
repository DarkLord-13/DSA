class DetectSquares{

    private Map<Integer, Map<Integer, Integer>> points;

    public DetectSquares(){
        this.points = new HashMap<>();
    }
    
    public void add(int[] point){
        int x = point[0], y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point){
        int x = point[0], y = point[1];

        if (!points.containsKey(x)) return 0;

        int total = 0;

        Map<Integer, Integer> sameX = points.get(x);

        // Iterate over all points having same x-coordinate
        for(Map.Entry<Integer, Integer> entry : sameX.entrySet()){
            int y2 = entry.getKey();
            int freq = entry.getValue();

            if (y2 == y) continue;  // side length must be > 0

            int side = Math.abs(y2 - y);

            // Check square to the right (x + side)
            total += freq *
                    getCount(x + side, y) *
                    getCount(x + side, y2);

            // Check square to the left (x - side)
            total += freq *
                    getCount(x - side, y) *
                    getCount(x - side, y2);
        }

        return total;
    }

    private int getCount(int x, int y){
        if (!points.containsKey(x)) return 0;
        return points.get(x).getOrDefault(y, 0);
    }
}