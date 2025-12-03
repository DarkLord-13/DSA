class Solution{
    public long maxSum(int[][] grid, int[] limits, int k){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            return b[0] - a[0];
        });
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<grid.length; i++){
            map.put(i, 0);

            for(int j=0; j<grid[i].length; j++){
                q.add(new int[] {grid[i][j], i});
            }
        }

        long sum = 0;
        while(k > 0){
            int[] p = q.poll();
            int num = p[0], row = p[1];

            if(map.get(row) < limits[row]){
                sum += num;
                k--;
                map.put(row, map.get(row) + 1);
            }
        }

        return sum;
    }
}