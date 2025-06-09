class Solution{
    public int[][] sortMatrix(int[][] g){
        int n = g.length;

        if(n == 1){
            return g;
        }

        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> d = new PriorityQueue<>((x, y) -> {
            return y - x;
        });

        for(int i=0; i<n; i++){
            int col = 0;
            for(int row=i; row<n; row++){                
                d.add(g[row][col]);
                col++;                
            }

            col = 0;
            for(int row=i; row<n; row++){
                g[row][col] = d.poll();
                col++;                
            }
        }

        for(int j=1; j<n; j++){
            int row = 0;
            for(int col=j; col<n; col++){
                a.add(g[row][col]);
                row++; 
            }

            row = 0;
            for(int col=j; col<n; col++){
                g[row][col] = a.poll();
                row++; 
            }
        }

        return g;
    }
}