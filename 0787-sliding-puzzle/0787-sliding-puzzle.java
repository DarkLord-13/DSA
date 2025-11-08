class Solution{

    private int[] x = {-1, 0, +1, 0}, y = {0, +1, 0, -1};

    public int slidingPuzzle(int[][] g){
        Queue<int[][]> q = new LinkedList<>();
        q.add(g);

        Set<String> set = new HashSet<>();

        int moves = 0;
        while(!q.isEmpty()){
            int s = q.size();

            for(int k=0; k<s; k++){
                g = q.poll();

                if(isValid(g)) return moves;

                int i = 0, j = 0;
                outer:
                for(i=0; i<2; i++){
                    for(j=0; j<3; j++){
                        if(g[i][j] == 0) break outer;
                    }
                }

                for(int p=0; p<4; p++){
                    int ni = i + x[p], nj = j + y[p];
                    
                    if(isSafe(ni, nj)){

                        int[][] ng = copyArray(g);
                        swap(i, j, ni, nj, ng);

                        String str = toString(ng);
                        if(!set.contains(str)){
                            set.add(str);
                            q.add(ng);
                        }
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private boolean isValid(int[][] g){
        if(g[0][0] != 1 || g[0][1] != 2 || g[0][2] != 3) return false;
        else if(g[1][0] != 4 || g[1][1] != 5 || g[1][2] != 0) return false;
        else return true;
    }

    private boolean isSafe(int i, int j){
        if(i >= 0 && j >= 0 && i < 2 && j < 3) return true;
        else return false;
    }

    private int[][] copyArray(int[][] g){
        int[][] ng = new int[2][3];

        for(int i=0; i<2; i++){
            for(int j=0; j<3; j++){
                ng[i][j] = g[i][j];
            }
        }

        return ng;
    }

    private void swap(int i, int j, int ni, int nj, int[][] g){
        int temp = g[i][j];
        g[i][j] = g[ni][nj];
        g[ni][nj] = temp;
    }

    private String toString(int[][] g){
        String s = Arrays.toString(g[0]);
        s += Arrays.toString(g[1]);

        return s;
    }
}