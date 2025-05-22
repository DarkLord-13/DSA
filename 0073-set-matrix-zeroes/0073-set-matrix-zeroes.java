class Solution{
    public void setZeroes(int[][] g){
        int m = g.length;
        int n = g[0].length;
        boolean rowZero = false, colZero = false;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(g[i][j] == 0){
                    g[i][0] = 0;
                    g[0][j] = 0;

                    if(i == 0){
                        rowZero = true;
                    }
                    if(j == 0){
                        colZero = true;
                    }
                }
            }
        } //print(g);

        for(int j=1; j<n; j++){
            if(g[0][j] == 0){
                for(int i=1; i<m; i++){
                    g[i][j] = 0;
                }
            }
        } //print(g);

        for(int i=1; i<m; i++){
            if(g[i][0] == 0){
                for(int j=1; j<n; j++){
                    g[i][j] = 0;
                }
            }
        }

        if(rowZero){
            for(int j=0; j<n; j++){
                g[0][j] = 0;
            }
        }

        if(colZero){
            for(int i=0; i<m; i++){
                g[i][0] = 0;
            }
        }
    }

    void print(int[][] g){
        for(int[] a: g){
            for(int i: a){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}